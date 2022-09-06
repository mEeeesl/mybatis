package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;

public interface Map {
	int insertUser(User user); // 리턴타입은 int , User user = domain
	
	int insertUser2(@Param("userId") int userId,  // 파라미터 데이터가 3개 이상이면 도메인으로 보내주는게 나음
					@Param("userName") String userName, // 파라미터 네임을 지정 @Param
					@Param("regDate") LocalDate regDate);
	// ▲방법1 ▼방법2
	int insertUser3(int userId, String userName, LocalDate regDate);
	
}
