package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentList();
	StudentVO selectOne(String sno);
	int insertStudent(StudentVO svo);
	int deleteStudent(String sno);
	
	
	List<MemberVO> memberList(@Param("res") String res, @Param("order") String order);

	// 로그인체크
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
}
