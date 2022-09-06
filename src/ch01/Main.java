package ch01; // �̰� ���̹�Ƽ���� ���ϸ� �������ڵ巡 ������ ���̹�Ƽ�����Ѵ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null; // Ŀ�ؼ��� ��Ÿ���� �ڹٰ�ü
		PreparedStatement stmt = null;//Ŀ�ؼ��� ���ؼ� ����(Statement)�� ����, �ڹٰ�ü�� ���� �����Ŵ�
		ResultSet rs = null; // ���̺��� ��üȭ�Ѱ��� ���� �ڹٰ�ü
		
		try {
			//Ŀ�ؼ��� ���� ����,
			Class.forName("oracle.jdbc.driver.OracleDriver");// �ش�Ŭ������ ����Ʈ�ڵ带 �޸𸮷� �ε���Ŵ
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);//Ŀ�ؼǸα�
			//���� �۾�
			String query = "SELECT USER_ID, USER_NAME, REG_DATE";
			query += " FROM USERS"; //spaghetti code
			stmt = conn.prepareStatement(query);
			//�غ��� ������ ����Ŭ�� ������
			rs = stmt.executeQuery(); //rs���� john�� terry�� �ִ»���
			
			// OR mapping(Object Relation) = �ڹٰ�ü + ���̺�(�ȿ��ִ� recode) �� 2���� Object�� Mapping �ϴ°�
			// row�� ������ �۾� ( ���̺� �ȿ� ����ִ��� �𸣴ϱ� �ݺ��� while)
			User user = null;
			while(rs.next()) { //next()�� ȣ��ɶ����� ù��° recode����  �ι�° recode�� Ŀ���̵� + recode�� ������ true, ���� ������ false ����
				user = new User(); // ���� ù��°���̰�, ��, �׸��� ���� ������ü�� ������.
				user.setUserId(rs.getInt(1)); //1��°�ʵ�
				user.setUserName(rs.getString(2)); //2�����ʵ�
				user.setRegDate(rs.getDate(3)); //3��°�ʵ�
				
				System.out.println(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {}	
		} 
	}
}
/*
DB�� Ŀ�ؼ��� ���� Ŭ���̾�Ʈ�� ����� ������.

Ŀ�ؼ��� �������� �������� �ʿ�.
�� �������� �̸� ���������� �����س��� 
�ٲ�� �ȵǴ� final�� ����

Uniform Resource Locator ����,Ʋ�� ���� ǥ����, �ڿ��� �ּ�

jdbc:oracle:thin:@ ���� URL ������Ʈ
���Ŀ� DB_URL ��Ƽ� ����Ŭ������ ��������

��ó�� �ϸ� ����Ŭ, �ڹ� �� ���� �Ӵ���( spaghetti code �ڵ尡 �����ϰ� �ھ�Ų ��� ������ǥ��)
�� ������� ����������
mybatis�� �̿��ϸ� ������ ����ǰ� �� �� �ذ�ȴ���

OR mapping(Object Relation) = �ڹٰ�ü + ���̺�(�ȿ��ִ� recode) �� 2���� Object�� Mapping �ϴ°�
//next()�� ȣ��ɶ����� ù��° recode����  �ι�° recode�� Ŀ���̵� + recode�� ������ true, ���� ������ false ����


*/