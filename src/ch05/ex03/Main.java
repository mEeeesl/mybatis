package ch05.ex03;

import java.util.List;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		List<User> users = mapper.selectUsers(new Search(null, null));
		users = mapper.selectUsers(new Search("john", null));
		users = mapper.selectUsers(new Search("john", new Post("사", null)));
		users = mapper.selectUsers(new Search(null, new Post("정", null)));
		users = mapper.selectUsers(new Search(null, new Post(null, "동학")));
		
		// users = mapper.selectUsers(new Search(null, new Post("정", "결")));
		// >> 값이 리턴이 안됨;
		
		users.forEach(System.out::println);
	}
}
