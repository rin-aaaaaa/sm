package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.BoardVo;

public class BoardDAO extends ADAO {
	// 게시판 출력
	// =============================================================================
	public List<BoardVo> boardList() {
		String sql = "select b.b_no,\r\n" //
				+ "       m.nickname,\r\n" //
				+ "       b.title,\r\n" //
				+ "       b.b_content,\r\n" //
				+ "       b.b_date\r\n" //
				+ "from   master m JOIN notice_board b ON m.master_id = b.master_id";
		List<BoardVo> list = new ArrayList<>();

		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVo bvo = new BoardVo();

				String bDate = rs.getString("b_date");
				bDate = bDate != null ? bDate.substring(0, 10) : "";

				bvo.setBoardNo(rs.getInt("b_no"));
				bvo.setMasterNickname(rs.getString("nickname"));
				bvo.setBoardTitle(rs.getString("title"));
				bvo.setBoardContent(rs.getString("b_content"));
				bvo.setBoarDDate(bDate);

				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // 게시판 출력 끝
		// =============================================================================

	// 게시글 작성
	// =============================================================================
	public boolean insertBoard(BoardVo bvo) {
		String sql = "INSERT INTO notice_board (b_no, master_id, title, b_content)";
		sql += "values(board_seq.nextval, ?, ?, ?)";
		conn = getConn();
		int times = 1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(times++, bvo.getMasterId());
			psmt.setString(times++, bvo.getBoardTitle());
			psmt.setString(times++, bvo.getBoardContent());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리
	} // 게시글 작성 끝
		// =============================================================================

	// 글 단건조회
	// =============================================================================
	public List<BoardVo> boardExists(String bno) {
		String sql = "select b.b_no,\r\n" //
				+ "       m.nickname,\r\n" //
				+ "       b.title,\r\n" //
				+ "       b.b_content,\r\n" //
				+ "       b.b_date\r\n" //
				+ " from   master m JOIN notice_board b ON m.master_id = b.master_id" + " where b_no = ?";
		List<BoardVo> list = new ArrayList<>();

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bno);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVo bvo = new BoardVo();
				String bDate = rs.getString("b_date");
				bDate = bDate != null ? bDate.substring(0, 10) : "";
				bvo.setBoardNo(rs.getInt("b_no"));
				bvo.setMasterNickname(rs.getString("nickname"));
				bvo.setBoardTitle(rs.getString("title"));
				bvo.setBoardContent(rs.getString("b_content"));
				bvo.setBoarDDate(bDate);

				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // 글 단건조회 끝
		// =============================================================================

}
