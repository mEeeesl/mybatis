package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
				// insertUser의 리턴타입은 int
		/* - - - - - - -
		if(mapper.insertUser(new User(11, "abel", LocalDate.now())) > 0)
			System.out.println("성공 11");
		*/
		
		/*
		 11번 유저가 없는상태에서 실행시 - 성공 11
		 또 실행시키면 Error MYBATIS.USER_USERID_PK violated
		 PK 키는 고유한데 11번이 또 생기면 에러
		 developer에서 삭제 시키고 다시 실행시키면 - 성공 11
		*/
		
		/* - - - - - - -
		if(mapper.insertUser(new User(12, null, null)) > 0)
			System.out.println("성공 12");
		*/
		
		/* Error - null은 안댐 
		null 넣으려면 Map에서 조건을 수정해야함 
		#{userId, jdbcType=NUMERIC},
		#{userName, jdbcType=VARCHAR},
		#{regDate, jdbcType=DATE}
		*/
		
		/* - - - - - - - -
		if(mapper.insertUser2(13,"kianu", LocalDate.of(2022, 8, 15)) > 0)
			System.out.println("성공 13");
		*/	
			
		/*
		 Error Parameter 'userId' not found. == #{userId}를 못찾음,
		 @Param("userId / userName / regDate") 이거 붙여주면 찾음 
		 */
		
		if(mapper.insertUser3(14, "neo", LocalDate.now()) > 0)
			System.out.println("성공 14");
		// ▲ insertUser3 방식은 잘 안쓰는 방식
	}
}
/*
실행시키면 Developer에서 추가된 것을 볼 수 있다.

*/