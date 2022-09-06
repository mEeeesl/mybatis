package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;

public interface Map {
	int insertUser(User user); // ����Ÿ���� int , User user = domain
	
	int insertUser2(@Param("userId") int userId,  // �Ķ���� �����Ͱ� 3�� �̻��̸� ���������� �����ִ°� ����
					@Param("userName") String userName, // �Ķ���� ������ ���� @Param
					@Param("regDate") LocalDate regDate);
	// ����1 ����2
	int insertUser3(int userId, String userName, LocalDate regDate);
	
}
