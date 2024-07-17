package co.yedam.vo;

public class MasterVo {
	public String masterId; // 사용자 아이디
	private String masterPw; // 사용자 비번
	private String masterNickname; // 사용자 닉네임
	private String masterTDate; // 사용자 가입일

	
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getMasterPw() {
		return masterPw;
	}
	public void setMasterPw(String masterPw) {
		this.masterPw = masterPw;
	}
	public String getMasterNickname() {
		return masterNickname;
	}
	public void setMasterNickname(String masterNickname) {
		this.masterNickname = masterNickname;
	}
	public String getMasterTDate() {
		return masterTDate;
	}
	public void setMasterTDate(String masterTDate) {
		this.masterTDate = masterTDate;
	}
	
	
	@Override
	public String toString() {
		return "MasterVo [masterId=" + masterId + ", masterPw=" + masterPw + ", masterNickname=" + masterNickname
				+ ", masterTDate=" + masterTDate + "]";
	}

}
