package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

public interface Map {		// Ư�� ���� ã��
	User selectUser(int userId); // pk, index ��������ֱ⿡ �˻������� ���� ����
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}
//configuration�� �ϳ��� �־�ȴ�? ���� �������̽��� ���� ������ �߰��� ����½��̷�