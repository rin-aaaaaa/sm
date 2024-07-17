package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.StudentVo;

public interface StudentMapper {
	List<StudentVo> studentList();
	// insert, updete, delete => 변경된 처리 건수 반환
	int insertStudent(StudentVo svo); 
	int updateStudent(StudentVo svo); // 학생번호 기준 연락처 변경
	int deleteStudent(StudentVo stdNo);
}
