package ch05.domain;

import java.time.LocalDate;
import java.util.List;

public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	private List<Post> posts; //User has many posts
	
	// Test 목적으로 생성자를 만든거
	public User(int userId, String userName, LocalDate regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, posts);
	}
}
