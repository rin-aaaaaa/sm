package co.yedam.vo;

import java.util.Date;

public class StudentVo {
	private String stdNo; // std_no
	private String stdName; // std_name
	private String stdPhone; // std_phone
	private String address; // address
	private String birthDate; // birth_date
	private Date creationDate;
	
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		return "StudentVo [stdNo=" + stdNo + ", stdName=" + stdName + ", stdPhone=" + stdPhone + ", address=" + address
				+ ", birthDate=" + birthDate + ", creationDate=" + creationDate + "]";
	}
	
	public String briefShow() {
		return stdNo+"  "+stdName+"  "+stdPhone+"  "+address+"  "+birthDate;
	}
	
	
}
