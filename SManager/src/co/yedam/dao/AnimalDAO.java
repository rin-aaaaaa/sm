package co.yedam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.AnimalVo;
import co.yedam.vo.BoardVo;
import co.yedam.vo.MasterVo;
import co.yedam.vo.StudentVo;

public class AnimalDAO extends ADAO {

	// 목록반환 기능
	// =============================================================================
	public List<AnimalVo> selectList() {
		String sql = "select m.nickname,\r\n" //
				+ "       a.animal_name,\r\n" //
				+ "   	   a.animal_type,\r\n"//
				+ "       a.species,\r\n" //
				+ "   	   a.birth_date,\r\n"//
				+ "       a.important\r\n" //
				+ "from   animal a JOIN master m ON m.master_id = a.master_id\r\n" //
				+ "order by birth_date";

		List<AnimalVo> list = new ArrayList<>();

		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				AnimalVo avo = new AnimalVo();

				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";

				avo.setMasterNickname(rs.getString("nickname"));
				avo.setAnimalName(rs.getString("animal_name"));
				avo.setAnimalType(rs.getString("animal_type"));
				avo.setAnimalSpecies(rs.getString("species"));
				avo.setAnimalBirthDate(birth);
				avo.setAnimalImportant(rs.getString("important"));

				list.add(avo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // 목록반환 기능 끝
		// =============================================================================

	// 로그인
	// =============================================================================
	public boolean checkLogin(String masterId, String password) {
		boolean loggedIn = false;
		String sql = "SELECT COUNT(*) AS cnt FROM master WHERE master_id = ? AND pw = ?";

		conn = getConn();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, masterId);
			psmt.setString(2, password);

			rs = psmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt("cnt");
				if (count == 1) {
					loggedIn = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs);
		}

		return loggedIn;
	} // 로그인 끝
		// =============================================================================

	private void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 로그인 끝
		// =============================================================================

	// 닉네임 단건조회
	// =============================================================================
	public String masterExists(String nno) {
		String sql = "select nickname from master";
		sql += "      where master_id = ?";

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("nickname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	} // 닉네임 단건조회 끝
		// =============================================================================

	// 사용자 목록출력
	// =============================================================================
	public List<AnimalVo> selectListByMasterId(String masterId) {
		String sql = "SELECT m.nickname, " //
				+ "       a.animal_name, " //
				+ "       a.animal_type, " //
				+ "       a.species, " //
				+ "       a.birth_date, " //
				+ "       a.important, " //
				+ "       a.animal_id " //
				+ "FROM master m " //
				+ "JOIN animal a ON m.master_id = a.master_id " //
				+ "WHERE m.master_id = ? " //
				+ "ORDER BY a.birth_date";

		List<AnimalVo> mlist = new ArrayList<>();
		conn = getConn();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, masterId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AnimalVo avo = new AnimalVo();

				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";

				avo.setMasterNickname(rs.getString("nickname"));
				avo.setAnimalName(rs.getString("animal_name"));
				avo.setAnimalType(rs.getString("animal_type"));
				avo.setAnimalSpecies(rs.getString("species"));
				avo.setAnimalBirthDate(birth);
				avo.setAnimalImportant(rs.getString("important"));
				avo.setAnimalId(rs.getInt("animal_id"));
				mlist.add(avo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mlist;
	} // 사용자 목록출력 끝
		// =============================================================================

	// 등록기능
	// =============================================================================
	public boolean insertAnimal(AnimalVo avo) {
		String sql = "INSERT INTO animal (animal_id, master_id, animal_name, animal_type, species, birth_date, important)";
		sql += "values(animal_seq.nextval, ?, ?, ?, ?, ?, ?)";
		conn = getConn();
		int times = 1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(times++, avo.getMasterId());
			psmt.setString(times++, avo.getAnimalName());
			psmt.setString(times++, avo.getAnimalType());
			psmt.setString(times++, avo.getAnimalSpecies());
			psmt.setString(times++, avo.getAnimalBirthDate());
			psmt.setString(times++, avo.getAnimalImportant());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리
	} // 등록기능 끝
		// =============================================================================

	// 수정기능
	// =============================================================================
	public boolean updateMaster(MasterVo mvo) {
		Connection conn = getConn();
		String sql = "UPDATE master";
		sql += " set	nickname = nvl('" + mvo.getMasterNickname() + "', nickname)";
		sql += "WHERE 	master_id = '" + mvo.getMasterId() + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//

	public boolean updateAnimal(AnimalVo avo) {
		Connection conn = getConn();
		String sql = "UPDATE animal";
		sql += " set	animal_name = nvl('" + avo.getAnimalName() + "', animal_name)";
		sql += ", 		animal_type = nvl('" + avo.getAnimalType() + "', animal_type)";
		sql += ", 		species = nvl('" + avo.getAnimalSpecies() + "', species)";
		sql += ",		birth_date = nvl('" + avo.getAnimalBirthDate() + "', birth_date)";
		sql += ",		important = nvl('" + avo.getAnimalImportant() + "', important)";
		sql += "WHERE 	animal_id = '" + avo.getAnimalId() + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // 수정기능 끝
		// =============================================================================

	// 삭제기능
	public boolean delAnimal(int ano) {
		conn = getConn();
		String sql = "delete from animal";
		sql += " WHERE animal_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ano);

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // 삭제기능
		// =============================================================================

}