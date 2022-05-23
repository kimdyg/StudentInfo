package com.callor.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV1;
import com.callor.student.util.IndexInfo;
import com.callor.student.util.Line;
import com.callor.studentVO.StudentVO;

public class StudentController {

	private final Scanner scan;
	private final List<StudentVO> stList;
	private final StudentService stService;
	private final MenuController menu;

	public StudentController() {
		scan = new Scanner(System.in);

		String stFileName = "src/com/callor/student/controller/student.txt";
		stList = new ArrayList<>();
		menu = new MenuController();
		stService = new StudentServiceImplV1(stList, stFileName);

		// TODO Auto-generated constructor stub
	}

	public Scanner getScan() {
		return scan;
	}

	public StudentService getStService() {
		return stService;
	}

	public Integer selectMenu() {
		while (true) {
			menu.viewStMenu();
			String strKey = scan.nextLine();
			if (strKey.equals("QUIT")) {
				return -1;
			}
			Integer intKey = 0;
			try {
				intKey = Integer.valueOf(strKey);
			} catch (Exception e) {
				System.out.println("업무를 다시 선택하세요");
				continue;
			}
			if (intKey == 1) {
				System.out.println("학생 로딩...");
				stService.inputStudent();
				System.out.println("학생정보 파일을 모두 읽었습니다..");
			} else if (intKey == 2) {
				// 전체 학생리스트 보이기
				List<StudentVO> stList = stService.getStudents();
				if (stList.size() < 1) {
					System.out.println("학생정보 파일을 먼저 로딩하세요");
					continue;
				}
				System.out.println(Line.dLine(50));
				System.out.println("학생 정보 리스트");
				System.out.println(Line.sLine(50));
				System.out.println("학번\t이름\t학과\t학년\t전화번호\n");
				System.out.println(Line.sLine(50));
				for (StudentVO vo : stList) {
					System.out.print(vo.getStNum() + "\t");
					System.out.print(vo.getStName() + "\t");
					System.out.print(vo.getStDept() + "\t");
					System.out.print(vo.getStGrade() + "\t");
					System.out.print(vo.getStTel() + "\n");
				}
				System.out.println(Line.dLine(50));

			} else if (intKey == 3) {
				System.out.println("학생 정보 추가하기");
				StudentVO stVO = StudentVO.builder()
						.stName("학번")
						.stNum("이름")
						.stDept("학과")
						.stTel("전화번호")
						.build();
				stList.add(stVO);
			} else if (intKey == 4) {
				System.out.println("이름 검색하기");
			} else {
				System.out.println("1 ~ 4 중에서 선택하세요");
			}
		}

	}
}
