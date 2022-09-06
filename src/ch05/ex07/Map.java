package ch05.ex07;

import java.util.List;

import ch05.domain.User;

public interface Map {
	List<User> selectUsers(int[] userIds);
	List<User> selectUsers2(List<String> userNames);
	
}


/* 
	파라미터로 도메인을받거나 문자, 날짜를 받거나 그랬는데, 
	파라미터로 컬렉션을 받는경우
	컬렉션은 배열 아님 리스트

	여기선 파라미터 네임이 없는 상태임.
	
*/