package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

public interface Map {		// 특정 유저 찾기
	User selectUser(int userId); // pk, index 만들어져있기에 검색성능이 가장 빠름
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}
//configuration은 하나만 있어도된다? 맵퍼 인터페이스랑 맵퍼 문서만 추가로 만드는식이래