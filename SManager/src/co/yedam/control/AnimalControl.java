package co.yedam.control;

import java.util.List;
import java.util.*;
import java.util.Scanner;

import co.yedam.dao.AnimalDAO;
import co.yedam.dao.BoardDAO;
import co.yedam.dao.CommentsDAO;
import co.yedam.vo.AnimalVo;
import co.yedam.vo.BoardVo;
import co.yedam.vo.CommentsVo;
import co.yedam.vo.MasterVo;

public class AnimalControl {
	Scanner scn = new Scanner(System.in);
	AnimalDAO adao = new AnimalDAO();
	BoardDAO bdao = new BoardDAO();
	CommentsDAO cdao = new CommentsDAO();
	String masterId;

	// run
	// =============================================================================
	public void run() {
		boolean isTrue = true;
		System.out.println();
		System.out.println(" ██╗  ██╗███████╗██╗     ██╗      ██████╗     ██╗");
		System.out.println(" ██║  ██║██╔════╝██║     ██║     ██╔═══██╗    ██║");
		System.out.println(" ███████║█████╗  ██║     ██║     ██║   ██║    ██║");
		System.out.println(" ██╔══██║██╔══╝  ██║     ██║     ██║   ██║    ╚═╝");
		System.out.println(" ██║  ██║███████╗███████╗███████╗╚██████╔╝    ██╗");
		System.out.println(" ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝     ╚═╝");
		System.out.println();

		if (!login()) {
			System.out.println("로그인 실패. 프로그램을 종료합니다.");
			return;

		}

		while (isTrue) {

			System.out.println("\n1.반려동물 목록    2.정보수정    3.게시판    4.종료");
			System.out.println("=========================================");

			System.out.print("선택 > ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				animalList();
				break;

			case 2:
				run2();
				break;

			case 3:
				boardList();
				break;

			case 4:
				System.out.println();
				System.out.println(" ██████╗ ██╗   ██╗███████╗    ██████╗ ██╗   ██╗███████╗");
				System.out.println(" ██╔══██╗╚██╗ ██╔╝██╔════╝    ██╔══██╗╚██╗ ██╔╝██╔════╝");
				System.out.println(" ██████╔╝ ╚████╔╝ █████╗      ██████╔╝ ╚████╔╝ █████╗  ");
				System.out.println(" ██╔══██╗  ╚██╔╝  ██╔══╝      ██╔══██╗  ╚██╔╝  ██╔══╝ ");
				System.out.println(" ██████╔╝   ██║   ███████╗    ██████╔╝   ██║   ███████╗");
				System.out.println(" ╚═════╝    ╚═╝   ╚══════╝    ╚═════╝    ╚═╝   ╚══════╝");
				isTrue = false;

			}
		}
	}// run
		// =============================================================================

	// 목록 출력 기능
	// //=======================================================================================
	void animalList() {
		int cnt = 0;
		List<AnimalVo> animal = adao.selectList();
		System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
		System.out.println("　번호　│　사용자 닉네임　│　반려동물이름　│　반려동물종류　│　반려동물품종　│　반려동물생일　│　특이사항　");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────");
		for (AnimalVo svo : animal) {
			System.out.println(++cnt + "    " + svo.animalShow());
		}
	}// 목록 출력 기능
		// ======================================================================================

	// run2
	// =============================================================================
	public void run2() {
		boolean isTrue = true;

		while (isTrue) {
			int cnt = 0;
			List<AnimalVo> animals = adao.selectListByMasterId(masterId); //

			System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
			System.out.println("　번호　│　사용자 닉네임　│　반려동물이름　│　반려동물종류　│　반려동물품종　│　반려동물생일　│　특이사항　");
			System.out.println("─────────────────────────────────────────────────────────────────────────────────");
			for (AnimalVo svo : animals) {
				System.out.println(++cnt + "    " + svo.animalShow());
			}
			System.out.println("\n1.등록    2.수정    3.삭제    4.처음으로 ");
			System.out.println("=======================================");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {

			case 1:
				animalAdd();
				break;

			case 2:
				animalMod();
				break;

			case 3:
				animalDel();
				break;

			case 4:
				System.out.println("처음으로 이동");
				isTrue = false;

			}
		}
	}// run2 종료
		// =============================================================================

	// 로그인
	// =============================================================================
	public boolean login() {
		String nno = "";
		String id = "";
		String pw = "";
		while (true) {
			System.out.print(" ID 입력 > ");
			id = scn.nextLine();
			System.out.print(" 비밀번호 입력 > ");
			pw = scn.nextLine();
			if (adao.checkLogin(id, pw)) {
				masterId = id;
				nno = adao.masterExists(id);
				break;
			}
			System.out.println("찾는 정보 없음 || 다시 입력 > ");
		}
		System.out.println(nno + "님 로그인 완료");
		return true;
	} // 로그인 끝

	// 사용자 목록 출력
	// =============================================================================
	void masterList() {

		int cnt = 0;
		List<AnimalVo> animals = adao.selectListByMasterId(masterId); //

		System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
		System.out.println("　번호　│　사용자 닉네임　│　반려동물이름　│　반려동물종류　│　반려동물품종　│　반려동물생일　│　특이사항　");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────");
		for (AnimalVo svo : animals) {
			System.out.println(++cnt + "    " + svo.animalShow());
		}
	} // 사용자 목록 끝
		// =============================================================================

	// 정보 등록기능
	// =============================================================================
	void animalAdd() {

		System.out.print("반려동물 이름 입력 > ");
		String aname = scn.nextLine();

		System.out.print("반려동물 종류 입력 > ");
		String type = scn.nextLine();

		System.out.print("반려동물 품종 입력 > ");
		String species = scn.nextLine();

		System.out.print("반려동물 생일 입력 > ");
		String birth = scn.nextLine();

		System.out.print("특이사항 입력 > ");
		String impt = scn.nextLine();

		AnimalVo animal = new AnimalVo();
		animal.setMasterId(masterId);
		animal.setAnimalName(aname);
		animal.setAnimalType(type);
		animal.setAnimalSpecies(species);
		animal.setAnimalBirthDate(birth);
		animal.setAnimalImportant(impt);

		// 등록기능 호출
		if (adao.insertAnimal(animal)) {
			System.out.println("등록완료!\n");
		} else {
			System.out.println("처리중 예외발생!\n");

		}

	} // 정보 등록 끝
		// =============================================================================

	// 정보 수정기능
	// =============================================================================
	void animalMod() {
		AnimalVo animal = new AnimalVo();
		MasterVo master = new MasterVo();

		int cnt = 0;
		List<AnimalVo> animals = adao.selectListByMasterId(masterId); //

		System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
		System.out.println("　번호　│　사용자 닉네임　│　반려동물이름　│　반려동물종류　│　반려동물품종　│　반려동물생일　│　특이사항　");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────");
		for (AnimalVo svo : animals) {
			System.out.println(++cnt + "    " + svo.animalShow());
		}
		System.out.print("수정할번호 > ");
		int sno = Integer.parseInt(scn.nextLine());
		animal.setAnimalId(animals.get(sno - 1).getAnimalId());
		// 번호선택 3번선택.
		System.out.print("사용자 닉네임 수정 > ");
		String nickname = scn.nextLine();

		System.out.print("반려동물 이름 수정 > ");
		String aname = scn.nextLine();

		System.out.print("반려동물 종류 수정 > ");
		String type = scn.nextLine();

		System.out.print("반려동물 품종 수정 > ");
		String species = scn.nextLine();

		System.out.print("반려동물 생일 수정 > ");
		String birth = scn.nextLine();

		System.out.print("특이사항 수정 > ");
		String impt = scn.nextLine();

		master.setMasterId(masterId);
		master.setMasterNickname(nickname);

		animal.setAnimalName(aname);
		animal.setAnimalType(type);
		animal.setAnimalSpecies(species);
		animal.setAnimalBirthDate(birth);
		animal.setAnimalImportant(impt);

		// 수정기능 호출
		if (adao.updateMaster(master)) {
		}
		if (adao.updateAnimal(animal)) {
			System.out.println("회원정보 수정 완료!\n");

		}
	} // 정보 수정 끝
		// =============================================================================

	// 정보 삭제기능
	// =============================================================================
	void animalDel() {
		AnimalVo animal = new AnimalVo();
		int cnt = 0;
		List<AnimalVo> animals = adao.selectListByMasterId(masterId); //

		System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
		System.out.println("　번호　│　사용자 닉네임　│　반려동물이름　│　반려동물종류　│　반려동물품종　│　반려동물생일　│　특이사항　");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────");
		for (AnimalVo svo : animals) {
			System.out.println(++cnt + "    " + svo.animalShow());
		}

		System.out.print("삭제할번호 > ");
		int ano = Integer.parseInt(scn.nextLine());
		animal.setAnimalId(animals.get(ano - 1).getAnimalId());
		if (adao.delAnimal(animals.get(ano - 1).getAnimalId())) {
			System.out.println("삭제완료!\n");
		} else {
			System.out.println("삭제 할 번호가 없습니다!\n1");
		}
	} // 정보 삭제 기능 끝
		// =============================================================================

	// 게시글 목록
	// =============================================================================
	void boardList() {
		List<BoardVo> board = bdao.boardList();

		System.out.println("\n 번호    작성자       제목                 작성일자      ");
		System.out.println("====================================================");
		for (BoardVo bvo : board) {
			System.out.println(bvo.boardShow());
		}
		String bno;
		while (true) {
			System.out.println("====================================================\n");
			System.out.println("글번호 선택  ||  글쓰기: w  ||  상위메뉴이동: q ");
			System.out.print("선택 > ");
			bno = scn.nextLine();
			try {
				double d = Double.parseDouble(bno);
				if (cdao.boardExists(bno) == 1) {
					showDetail(bno);
					break;
				}
			} catch (NumberFormatException nfe) {
				if (bno.equals("w")) {
					boardAdd();

				} else if (bno.equals("q")) {
					return;
				}
			}

		}
	} // 게시글 목록 끝
		// =============================================================================

	// 게시글 상세보기
	// =============================================================================
	void showDetail(String bno) {
		while (true) {
			List<BoardVo> board = bdao.boardExists(bno);

			for (BoardVo bvo : board) {
				System.out.println("-----------------------------------");
				System.out.println("\n글　번　호 : " + bvo.getBoardNo());
				System.out.println("작　성　자 : " + bvo.getMasterNickname());
				System.out.println("제　　　목 : " + bvo.getBoardTitle());
				System.out.println("내　　　용 : " + bvo.getBoardContent());
				System.out.println("\n작성일자 : " + bvo.getBoarDDate());
				System.out.println("\n-----------------------------------");
			}

			// 댓글등록(w), 상위메뉴(q)
			commentList(bno);
			System.out.print(" 댓글등록 > 1　　||　　상위메뉴 > 2  : ");
			String cno = scn.nextLine();
			if (cno.equals("2")) {
				boardList();
				return;
			} else {
				commentsAdd(bno);
			}
		}
	} // 게시글 상세보기 끝
		// =============================================================================

	// 댓글목록(원글번호)
	// =============================================================================
	void commentList(String cno) {
		List<CommentsVo> comments = cdao.comments(cno);
		for (CommentsVo cvo : comments) {
			System.out.printf("%s님의 댓글　　　▶ %s ◀　　　%s\n", cvo.getMasterNickname(), cvo.getCommentsContent(),
					cvo.getCommentsCDate());
			System.out.println("-------------------------------------------------");
		}
	} // 댓글목록(원글번호)
		// =============================================================================

	// 게시글 작성
	// =============================================================================
	void boardAdd() {
		BoardVo bvo = new BoardVo();

		System.out.print(" 제목 입력 > ");
		String title = scn.nextLine();

		System.out.print(" 내용 입력 > ");
		String content = scn.nextLine();

		bvo.setMasterId(masterId);
		bvo.setBoardTitle(title);
		bvo.setBoardContent(content);

		// 등록기능 호출
		if (bdao.insertBoard(bvo)) {
			System.out.println("등록완료!\n");
		} else {
			System.out.println("처리중 예외발생!\n");
		}
		List<BoardVo> board = bdao.boardList();

		System.out.println("\n 번호    작성자       제목                 작성일자      ");
		System.out.println("====================================================");
		for (BoardVo vo : board) {
			System.out.println(vo.boardShow());
		}
	}// 게시글 작성 끝
		// =============================================================================

	// 댓글 작성
	// =============================================================================
	void commentsAdd(String bno) {
		CommentsVo cvo = new CommentsVo();

		System.out.print(" 댓글내용 입력 > ");
		String content = scn.nextLine();

		cvo.setMasterId(masterId);
		cvo.setBoardNo(Integer.parseInt(bno));
		cvo.setCommentsContent(content);

		// 등록기능 호출
		if (cdao.insertComments(cvo)) {
			System.out.println("등록완료!\n");
		} else {
			System.out.println("처리중 예외발생!\n");
		}
	}// 댓글 작성 끝
		// =============================================================================
}
