package com.callor.studentVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StudentVO {

	private String stNum;
	private String stName;
	private String stDept;
	private int stGrade;
	private String stTel;

	
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}

	public StudentVO(String stNum, String stName, int intGrade, String stDept, String stTel) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stGrade = intGrade;
		this.stDept = stDept;
		this.stTel = stTel;
	}

	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getIntGrade() {
		return getStGrade();
	}
	public void setIntGrade(int intGrade) {
		this.stGrade = intGrade;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}

	// VO 객체에 데이터를 저장한 후
	// 저장된 데이터가 잘 담겼는지
	//		확인하는 용도로 사용하기 위하여
	// toString() 메서드를 재 정의 한다
	@Override
	public String toString() {
		return "StudentVO [stNum=" + stNum + ", stName=" + stName + ", intGrade=" + stGrade + ", stDept=" + stDept
				+ ",  stTel=" + stTel + "]";
	}

}
