package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVo;

// 사용자 입력을 가이드, 처리된 결과 출력
public class StudentControl {
	Scanner scn = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();

	public void run() {
		boolean isTrue = true;
		System.out.println(" ▶ 학생관리 프로그램 V.10 ◀ ");
		while (isTrue) {
			System.out.println("1.학생목록   2.등록   3.수정   4.삭제   5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;

			case 3:
				modStudent();
				break;

			case 4:
				delStudent();
				break;

			case 5:
				System.out.println("종료합니다");
				isTrue = false;

			}
		}
	}// end of run()

	// 등록기능
	void addStudent() {
		System.out.print(" 학생번호 입력 > ");
		String sno = scn.nextLine();

		System.out.print(" 학생이릅 입력 > ");
		String sname = scn.nextLine();

		System.out.print(" 연락처 입력 > ");
		String phon = scn.nextLine();

		System.out.print(" 주소 입력 > ");
		String addr = scn.nextLine();

		System.out.print(" 생일 입력 > ");
		String birth = scn.nextLine();

		StudentVo std = new StudentVo();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(addr);
		std.setBirthDate(birth);

		// 등록기능 호출
		if (sdao.insertStudent(std)) {
			System.out.println("등록완료!\n");
		} else {
			System.out.println("처리중 예외발생!\n");
		}
	}

	// 수정기능 호출
	void modStudent() {
		String sno = "";
		while (true) {
			System.out.print(" 학생번호 수정 > ");
			sno = scn.nextLine();
			if (sdao.selectExists(sno) == 1) { // 학생번호 존재
				break;
			}
			System.out.println(" 찾는 학생번호가 없음 || 학생번호 다시 입력 > ");
		}

		System.out.print(" 학생이릅 수정 > ");
		String sname = scn.nextLine();

		System.out.print(" 연락처 수정 > ");
		String phon = scn.nextLine();

		System.out.print(" 주소 수정 > ");
		String addr = scn.nextLine();

		System.out.print(" 생일 수정 > ");
		String birth = scn.nextLine();

		StudentVo std = new StudentVo();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(addr);
		std.setBirthDate(birth);

		// 수정기능 호출
		if (sdao.modStudent(std)) {
			System.out.println("수정완료!\n");
		}
	}

	// 삭제 기능
	void delStudent() {
		System.out.print(" 삭제할 학생 번호 > ");
		String sno = scn.nextLine();
		if (sdao.delStudent(sno)) {
			System.out.println("삭제완료!\n");
		} else {
			System.out.println("삭제 할 학생번호가 없습니다!\n1");
		}
	}

	// 목록 출력 기능
	void studentList() {
		List<StudentVo> student = sdao.selectList();

		System.out.println(" 학생번호   학생이름      연락처         주소       생년월일   ");
		System.out.println("===================================================");
		for (StudentVo svo : student) {
			System.out.println(svo.briefShow());
		}
		System.out.println("===================================================\n");

	}// end of studentList()
}
