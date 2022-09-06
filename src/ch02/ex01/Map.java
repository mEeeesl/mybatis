package ch02.ex01;

import java.util.List;

import ch02.domain.User;

public interface Map {
	List<User> selectUsers();
}
// 테이블의 값이 없어도 List가 리턴됨.