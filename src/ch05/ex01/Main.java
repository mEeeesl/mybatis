package ch05.ex01;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		User user = mapper.selectUser(new Search("john", null));
		
		// isEmpty() 적용 전
		//content null.. exception 걸림
		//user = mapper.selectUser(new Search("john", new Post("정의", null)));
		user = mapper.selectUser(new Search("john", new Post(null, "고리")));
		
		user = mapper.selectUser(new Search("john", new Post("", "대")));
		
		// isEmpty() 적용 후
		user = mapper.selectUser(new Search("john", new Post("정의", "")));
		//user = mapper.selectUser(new Search("john", new Post("사랑", "대")));
		// if 는 둘다 일치해줘야 값 나오는듯. ▲ null 리턴
		// 다음에 배우는 choose ~ when ~ 에서는 [사랑: 너와 나의 연결고리]가 리턴됨
		System.out.println(user);
		
	}
}
