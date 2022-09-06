package ch05.ex04;

import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		System.out.println(mapper.updateUser(new User(2, "king", null)));
		// Console 값 '1'이 리턴됨
		// 수정된 값이 1개라는 뜻이다.
		
	}
}
