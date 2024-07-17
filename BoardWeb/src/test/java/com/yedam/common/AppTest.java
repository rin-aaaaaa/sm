package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.StudentMapper;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlsession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
		mapper.studentList().forEach(student -> {System.out.println(student);});
	}
}
