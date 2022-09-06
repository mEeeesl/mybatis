package ch01;

import java.sql.Date;

public class User {
	private int userId;
	private String userName;
	private Date regDate;
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s", userId, userName, regDate);
	}
	
	
}
/*
db의 테이블이 자바에선 클래스
db의 row는 자바의

number -> int
varchar2 -> String
date -> 자바 8버전 ? 옛날버전 Date를 씀


*/