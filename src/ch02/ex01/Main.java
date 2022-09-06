package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class); // Pool�̾��� .. interface Map�̾���..
		
		List<User> users = mapper.selectUsers();
		users.forEach(System.out::println); //���ٸ� �̷��Ե� ������
	}
}
