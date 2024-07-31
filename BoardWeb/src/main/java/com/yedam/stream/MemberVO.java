package com.yedam.stream;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 기본생성자 생성
@AllArgsConstructor // 전체사 값을 가지는 생성자 생성
// └ 이거 만들면 기본생성자 안만들어짐 기본 생성자 만드려면 @NoArgsConstructor 호출
@NoArgsConstructor
public class MemberVO implements Serializable{
	private int memberNo;
	private String memberName;
	private int point;

}
