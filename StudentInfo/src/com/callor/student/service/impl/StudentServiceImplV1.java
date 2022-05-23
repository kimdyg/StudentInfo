package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.util.IndexInfo;
import com.callor.studentVO.StudentVO;

public class StudentServiceImplV1 implements StudentService {

	private final List<StudentVO> stList;
	private final String stFileName;

	public StudentServiceImplV1() {
		List<StudentVO> sts = new ArrayList<>();
		this.stList = sts;
		this.stFileName = "";
		// TODO Auto-generated constructor stub
	}

	public StudentServiceImplV1(List<StudentVO> stList, String stFileName) {
		this.stList = stList;
		this.stFileName = stFileName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inputStudent() {

		InputStream is = null;

		try {
			is = new FileInputStream(this.stFileName);

		} catch (FileNotFoundException e) {
			System.out.println(stFileName + "파일을 찾을 수 없습니다");
			return;
		}

		try (Scanner fileRead = new Scanner(is)) {
			while(fileRead.hasNext()) {
				String stLine = fileRead.nextLine();
				String[] stInfo = stLine.split(":");
				String stNum = stInfo[IndexInfo.ST.ST_NUM];
				String stName = stInfo[IndexInfo.ST.ST_NAME];
				String stDept = stInfo[IndexInfo.ST.ST_DEPT];
				String stGrade = stInfo[IndexInfo.ST.ST_GRADE];
				String stTel = stInfo[IndexInfo.ST.ST_TEL];
				int intGrade = Integer.valueOf(stGrade);
				
				StudentVO stVO = new StudentVO(stNum,stName,stDept,intGrade,stTel);
				stList.add(stVO);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void printStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentVO> getStudents() {
		// TODO Auto-generated method stub
		return this.stList;
	}

	@Override
	public List<StudentVO> findByStName(String stNmame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentVO findByStNum(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
