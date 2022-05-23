package com.callor.student.service;

import java.util.List;

import com.callor.studentVO.StudentVO;

public interface StudentService {

	public void inputStudent();
	public void printStudent();
	public List<StudentVO> getStudents();
	public List<StudentVO> findByStName(String stName);
	public StudentVO findByStNum(String stNum);
}
