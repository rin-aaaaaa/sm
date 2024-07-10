package co.yedam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVo;

// 목록(R), 등록(C), 수정(U), 삭제(D)
// 주의: DAO 메세지(syso)가 없음

public class StudentDAO extends DAO {

	// 등록기능
	public boolean insertStudent(StudentVo svo) {
		String sql = "insert into tbl_student (std_no, std_name, std_phone, address, birth_date )";
		sql += "values(?, ?, ?, ?, ?)";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdNo());
			psmt.setString(2, svo.getStdName());
			psmt.setString(3, svo.getStdPhone());
			psmt.setString(4, svo.getAddress());
			psmt.setString(5, svo.getBirthDate());

			int r = psmt.executeUpdate(); // 쿼리실행
			if(r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리
	}

	// 단건조회
	public int selectExists(String sno) {
		String sql = "select count(1) from tbl_student";
		sql += "      where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 수정기능
	public boolean modStudent(StudentVo svo) {
		String sql = "update tbl_student";
		sql += " set	std_name = ?";
		sql += ", 		std_phone = ?";
		sql += ", 		address = ?";
		sql += ",		birth_date = ?";
		sql += "WHERE 	std_no = ?"; 
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdName());
			psmt.setString(2, svo.getStdPhone());
			psmt.setString(3, svo.getAddress());
			psmt.setString(4, svo.getBirthDate());
			psmt.setString(5, svo.getStdNo());

			int r = psmt.executeUpdate(); // 쿼리실행
			if(r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리
	}
//		Connection conn = getConn();
//		String sql = "UPDATE tbl_student";
//		sql += " set	std_name = nvl('" + svo.getStdName() + "', std_name)";
//		sql += ", 		std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
//		sql += ", 		address = nvl('" + svo.getAddress() + "', address)";
//		sql += ",		birth_date = nvl('" + svo.getBirthDate() + "', birth_date)";
//		sql += "WHERE 	std_no = '" + svo.getStdNo() + "'";
//		try {
//			System.out.println(sql);
//			Statement stmt = conn.createStatement();
//			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 리턴해준다.
//			if(r == 1) {
//                return true; // 정상처리
//            }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
	// 삭제기능
	public boolean delStudent(String std_no) {
		Connection conn = getConn();
		String sql = "delete from tbl_student";
		sql += " WHERE std_no = '" + std_no + "'";

		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete
			if(r == 1) {
                return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 목록반환 기능
	public List<StudentVo> selectList() {
		String sql = "select * from tbl_student order by std_no";
		List<StudentVo> list = new ArrayList<>();

		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentVo svo = new StudentVo();
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";
				svo.setAddress(rs.getString("address"));
				svo.setBirthDate(birth);
				svo.setCreationDate(rs.getDate("creation_date"));
				svo.setStdName(rs.getString("std_name"));
				svo.setStdNo(rs.getString("std_no"));
				svo.setStdPhone(rs.getString("std_phone"));

				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	} // end of
}
