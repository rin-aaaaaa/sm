package co.yedam;

import co.yedam.control.StudentControl;

public class MainApplication {
	public static void main(String[] args) {
		// 프로그램의 시작
		// 1.학생관리 2.과정관리
		int menu = 1;
		
		StudentControl scontrol = new StudentControl();
		scontrol.run();
	}
}
