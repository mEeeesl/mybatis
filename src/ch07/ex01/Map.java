package ch07.ex01;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import ch07.domain.User;

public interface Map {	// 7장은 어노테이션으로 하는건데 추천하지않는 방식임
	@Select("select user_id userId, user_name userName, reg_date regDate "
			+ "from users "
			+ "order by user_id")
	List<User> selectUsers();
}

// 쓰지마 이 방식