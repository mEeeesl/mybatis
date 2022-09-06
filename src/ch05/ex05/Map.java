package ch05.ex05;

import ch05.domain.User;

public interface Map { 
	User selectUser(String userName);
	// userName은 도메인이 아니고, 파라미터가 없는 상태임 (SQL입장)
	
}
