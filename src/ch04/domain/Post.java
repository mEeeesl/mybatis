package ch04.domain;

public class Post {
	private String title;
	private String content;
	
	//생성자 , setter 안해도 DI + OR Mapping 알아서 잘함
	
	@Override
	public String toString() {
		return String.format("%s %s", title, content);
	}
}
