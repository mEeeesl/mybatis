package ch07.ex01;

import config.Configuration;

public class Main { // 7장은 쓰지마셈
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		mapper.selectUsers().forEach(System.out::println);
	}
}
