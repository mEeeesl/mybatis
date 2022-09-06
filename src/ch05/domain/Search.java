package ch05.domain;

public class Search {	//relation과 무관한 domain
	private String userName; // 작성자명
	private Post post; // 글 제목, 글 내용
	
	public Search(String userName, Post post) {
		this.userName = userName;
		this.post = post;
	}
}
