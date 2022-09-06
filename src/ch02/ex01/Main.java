package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class); // Pool이었고 .. interface Map이었고..
		
		List<User> users = mapper.selectUsers();
		users.forEach(System.out::println); //람다를 이렇게도 쓸수있
	}
}
