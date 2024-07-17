package co.yedam.vo;

import java.util.Date;
import lombok.Data;




@Data

public class StudentVo {
	private String stdNo; // std_no
	private String stdName; // std_name
	private String stdPhone; // std_phone
	private String address; // address
	private String birthDate; // birth_date
	private Date creationDate;

	public String briefShow() {
		return stdNo+"  "+stdName+"  "+stdPhone+"  "+address+"  "+birthDate;
	}

	
}
