package co.yedam.vo;

public class BoardVo extends MasterVo {
//	private String masterId; // 사용자 아이디
	private String masterNickname; // 사용자 닉네임

	private int boardNo; // 게시판 글번호
	private String boardTitle; // 게시판 제목
	private String boardContent; // 게시판 내용
	private String boarDDate; // 게시판 작성일

//	public String getMasterId() {
//		return masterId;
//	}
//	public void setMasterId(String masterId) {
//		this.masterId = masterId;
//	}
	public String getMasterNickname() {
		return masterNickname;
	}
	public void setMasterNickname(String masterNickname) {
		this.masterNickname = masterNickname;
	}
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoarDDate() {
		return boarDDate;
	}

	public void setBoarDDate(String boarDDate) {
		this.boarDDate = boarDDate;
	}

	@Override
	public String toString() {
		return "BoardVo [masterNickname=" + masterNickname + ", boardNo=" + boardNo + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boarDDate=" + boarDDate + "]";
	}
	
	public String boardShow() {
		return String.format("%-5s %-7s %-20s %-10s",boardNo, masterNickname, boardTitle, boarDDate);
	}

}
