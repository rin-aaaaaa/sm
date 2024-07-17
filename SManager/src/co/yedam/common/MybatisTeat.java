package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.StudentVo;

public class MybatisTeat {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession sqlSession = factory.openSession(true); //SqlSessionFactory
		// 매퍼인터페이스의 구현 => 구현클래스
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		StudentVo student = new StudentVo();
		// insert
//		student.setStdNo("s2024-09");
//		student.setStdName("이승상");
//		student.setStdPhone("010-2234-1234");
//		int cnt = mapper.insertStudent(student);
		
		// update 학생번호 기준 연락처 변경
//		student.setStdNo("s2024-09");
//		student.setStdPhone("010-3333-5555");
//		int cnt = mapper.updateStudent(student);
		
		
		// delete
		student.setStdNo("s2024-08");
		int cnt = mapper.deleteStudent(student);
		
		System.out.println("처리된 건수: " + cnt);
//		sqlSession.commit(); // 커밋 하는게 귀찮으면 위 [openSession(true)]< true 넣으면 됨
		
		List<StudentVo> list = mapper.studentList();
		for(StudentVo svo : list) {
			System.out.println(svo);
		}
		System.out.println("OK");
		}
}
