package ch05.domain;

public class Search {	//relation�� ������ domain
	private String userName; // �ۼ��ڸ�
	private Post post; // �� ����, �� ����
	
	public Search(String userName, Post post) {
		this.userName = userName;
		this.post = post;
	}
}
