package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.CommentsVo;

public class CommentsDAO extends ADAO {
	// 댓글 단건조회
	// =============================================================================
	public List<CommentsVo> comments(String cno) {
		String sql = "select c.b_no,\r\n" //
				+ "       c.c_no,\r\n" //
				+ "       m.nickname,\r\n" //
				+ "       c.c_content ,\r\n" //
				+ "       c.c_date\r\n" //
				+ "from   master m JOIN comments c ON m.master_id = c.master_id\r\n" + "where c.b_no = ?";
		List<CommentsVo> list = new ArrayList<>();

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cno);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CommentsVo cvo = new CommentsVo();

				String cDate = rs.getString("c_date");
				cDate = cDate != null ? cDate.substring(0, 10) : "";

				cvo.setBoardNo(rs.getInt("b_no"));
				cvo.setCommentsNo(rs.getInt("c_no"));
				cvo.setMasterNickname(rs.getString("nickname"));
				cvo.setCommentsContent(rs.getString("c_content"));
				cvo.setCommentsCDate(cDate);

				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // 댓글 단건조회 끝
		// =============================================================================

	// 단건조회
	// =============================================================================
	public int boardExists(String bno) {
		String sql = "select count(1) from notice_board";
		sql += "      where b_no = ?";
		conn = getConn();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}// 단건조회 끝
		// =============================================================================

	// 댓글 작성
	// =============================================================================
	public boolean insertComments(CommentsVo cvo) {
		String sql = "INSERT INTO comments (c_no, b_no, master_id, c_content)";
		sql += "values(board_seq.nextval, ?, ?, ?)";
		conn = getConn();
		int times = 1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(times++, cvo.getBoardNo());
			psmt.setString(times++, cvo.getMasterId());
			psmt.setString(times++, cvo.getCommentsContent());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리
	} // 댓글 작성 끝
		// =============================================================================
}
