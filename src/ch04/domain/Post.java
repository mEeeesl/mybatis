package ch04.domain;

public class Post {
	private String title;
	private String content;
	
	//������ , setter ���ص� DI + OR Mapping �˾Ƽ� ����
	
	@Override
	public String toString() {
		return String.format("%s %s", title, content);
	}
}
