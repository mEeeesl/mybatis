package ch03.ex01;

import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		mapper.selectUsers().forEach(System.out::println);
		/*	Error 1. �����ο� �ڵ� ����ο��ߴµ� ������ ���� �ߺ��� ch02.domain�� user��
		 	ch03.domain - User�� ������ �����ָ�� @Alias("myUser") �̷�������
		 	
		 	Error 2. res.ch3.ex01.sqlMap.xml���� resultMap�� Type�� myUser�� ����
		 */
	}
}
