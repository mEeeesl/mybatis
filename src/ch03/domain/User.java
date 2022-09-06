package ch03.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("myUser") // 별명 중복 제거를 위해, Class의 별칭을 새로 만들어주기.
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	// 과제] users 와 addresses 사이의 relationship 을 디자인하라.
	private Address address;
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, address);
	}
}
