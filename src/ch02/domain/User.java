package ch02.domain;
							//���̹�Ƽ���� �⺻������ JDBC�� ����Ѵ�.
import java.time.LocalDate;

// ����] users Relation�� mapping �� User Object�� �������϶�.
public class User {	// 
	private int userId;
	private String userName;
	private LocalDate regDate;
	
	// DI �۾��� Setter or ������
	// ������ ���̾��ص� ���̹�Ƽ���� �˾Ƽ�������,
	// ���� ����Ϸ��� �̰� �������
	
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