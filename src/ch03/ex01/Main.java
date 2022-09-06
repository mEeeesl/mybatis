package ch03.ex01;

import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		mapper.selectUsers().forEach(System.out::println);
		/*	Error 1. 도메인에 자동 별명부여했는데 별명이 지금 중복됨 ch02.domain도 user임
		 	ch03.domain - User의 별명을 지어주면됨 @Alias("myUser") 이런식으로
		 	
		 	Error 2. res.ch3.ex01.sqlMap.xml에서 resultMap의 Type을 myUser로 변경
		 */
	}
}
