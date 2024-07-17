package co.yedam.vo;

public class CommentsVo extends MasterVo {

	private int commentsNo; // 댓글 글번호
	private String commentsContent; // 댓글 내용
	private String commentsCDate; // 댓글 작성일
	private int boardNo; // 게시판 글번호

	// public String getMasterId() {
//		return masterId;
//	}
//	public void setMasterId(String masterId) {
//		this.masterId = masterId;
//	}
//	public String getMasterNickname() {
//		return masterNickname;
//	}
//	public void setMasterNickname(String masterNickname) {
//		this.masterNickname = masterNickname;
//	}
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}

	public String getCommentsContent() {
		return commentsContent;
	}

	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public String getCommentsCDate() {
		return commentsCDate;
	}

	public void setCommentsCDate(String commentsCDate) {
		this.commentsCDate = commentsCDate;
	}

	@Override
	public String toString() {
		return "CommentsVo [masterNickname=" + this.getMasterNickname() + ", commentsNo=" + commentsNo + ", commentsContent=" + commentsContent + ", commentsCDate="
				+ commentsCDate + ", boardNo=" + boardNo + "]";
	}



}
