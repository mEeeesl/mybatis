package ch02.domain;
							//마이바티스는 기본적으로 JDBC를 사용한다.
import java.time.LocalDate;

// 과제] users Relation과 mapping 할 User Object을 디자인하라.
public class User {	// 
	private int userId;
	private String userName;
	private LocalDate regDate;
	
	// DI 작업은 Setter or 생성자
	// 원래는 굳이안해도 마이바티스가 알아서하지만,
	// 내가 사용하려고 이걸 만든거임
	
	public User(int userId, String userName, LocalDate regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
		
	@Override
	public String toString() {
		return String.format("%d %s %s", userId, userName, regDate);
	}
}