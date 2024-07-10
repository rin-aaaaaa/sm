package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVo;

public class AppTests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "jsp";
		String pass = "jsp";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
//			System.out.println("오라클 드라이버 없음");
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static void main(String[] args) {
		// 1. Oracle JDBC Driver 자바라이브러리
		// 2. Connection 객체
//		Scanner scn = new Scanner(System.in);
//
//		System.out.println("> 학생번호 입력");
//		String sno = scn.nextLine();
//
//		System.out.println("> 학생이릅 입력");
//		String sname = scn.nextLine();
//
//		System.out.println("> 연락처 입력");
//		String phon = scn.nextLine();
//
//		System.out.println("> 주소 입력");
//		String addr = scn.nextLine();
//
//		System.out.println("> 생일 입력");
//		String birth = scn.nextLine();

//		addStudent(sno, sname, phon); // 입력
//		modStudent(sno, sname, phon); // 수정
//		removeStudent(sno); // 삭제

//		modStu(sno, sname, phon, addr, birth); // 수정2
//		StudentVo std = new StudentVo();
//		std.setStdNo(sno);
//		std.setStdName(sname);
//		std.setStdPhone(phon);
//		std.setAddress(addr);
//		std.setBirthDate(birth);
//		modStu(std);

		search(); // 목록 조회
	}

//	 입력기능
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "INSERT into tbl_student (std_no, std_name, std_phone)";
		sql += "VALUES ('" + stdNo + "','" + stdName + "','" + phone + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수
			System.out.println("처리된 건수는" + r + "건");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정기능
	public static void modStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "UPDATE tbl_student";
		sql += " SET std_name = '" + stdName + "'";
		sql += ", std_phone = '" + phone + "'";
		sql += " WHERE std_no = '" + stdNo + "'";

		try {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 리턴해준다.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정 기능2
	// modStu(String stdNo, String stdName, String phone, String addr, String birth)
	public static void modStu(StudentVo svo) {
		Connection conn = getConn();
		String sql = "UPDATE tbl_student";
		sql += " set	std_name = nvl('" + svo.getStdName() + "', std_name)";
		sql += ", 		std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
		sql += ", 		address = nvl('" + svo.getAddress() + "', address)";
		sql += ",		birth_date = nvl('" + svo.getBirthDate() + "', birth_date)";
		sql += "WHERE 	std_no = '" + svo.getStdNo() + "'";
		try {
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수를 리턴해준다.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회기능
	public static void search() {
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from tbl_student");
			// [객체1, 객체2, 객체3]
			while (rs.next()) {
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth.substring(0, 10) : "";

				System.out.println(rs.getString("std_no") + ", " + rs.getString("std_name") + ", "
						+ rs.getString("std_phone") + ", " + rs.getString("address") + ", " + birth);
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 삭제기능
	public static void removeStudent(String std_no) {
		Connection conn = getConn();
		String sql = "delete from tbl_student";
		sql += " WHERE std_no = '" + std_no + "'";

		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete
			System.out.println("처리된 건수는" + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}//
