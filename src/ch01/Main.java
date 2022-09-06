package ch01; // 이건 마이바티스에 비하면 안좋은코드래 앞으로 마이바티스로한대

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null; // 커넥션을 나타내는 자바객체
		PreparedStatement stmt = null;//커넥션을 통해서 쿼리(Statement)를 보냄, 자바객체로 만들어서 담을거다
		ResultSet rs = null; // 테이블을 객체화한것을 담을 자바객체
		
		try {
			//커넥션을 먼저 맺자,
			Class.forName("oracle.jdbc.driver.OracleDriver");// 해당클래스의 바이트코드를 메모리로 로딩시킴
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);//커넥션맺기
			//쿼리 작업
			String query = "SELECT USER_ID, USER_NAME, REG_DATE";
			query += " FROM USERS"; //spaghetti code
			stmt = conn.prepareStatement(query);
			//준비한 쿼리를 오라클로 보내기
			rs = stmt.executeQuery(); //rs에는 john과 terry가 있는상태
			
			// OR mapping(Object Relation) = 자바객체 + 테이블(안에있는 recode) 이 2개를 Object로 Mapping 하는것
			// row를 꺼내는 작업 ( 테이블 안에 몇개나있는지 모르니까 반복문 while)
			User user = null;
			while(rs.next()) { //next()가 호출될때마다 첫번째 recode에서  두번째 recode로 커서이동 + recode가 있으면 true, 값이 없으면 false 리턴
				user = new User(); // 존이 첫번째값이고, 존, 테리를 넣을 유저객체를 만들자.
				user.setUserId(rs.getInt(1)); //1번째필드
				user.setUserName(rs.getString(2)); //2번쨰필드
				user.setRegDate(rs.getDate(3)); //3번째필드
				
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
DB와 커넥션을 맺을 클라이언트를 만드는 과정임.

커넥션을 맺으려면 정보들이 필요.
그 정보들을 미리 지역변수로 선언해놓자 
바뀌면 안되니 final로 선언

Uniform Resource Locator 문법,틀에 맞춰 표현한, 자원의 주소

jdbc:oracle:thin:@ 까진 URL 고정파트
향후에 DB_URL 담아서 오라클서버에 보낼거임

위처럼 하면 오라클, 자바 언어가 섞일 뿐더러( spaghetti code 코드가 복잡하게 뒤엉킨 모습 비유적표현)
좀 여러모로 지저분해짐
mybatis를 이용하면 별도로 저장되고 뭐 다 해결된다함

OR mapping(Object Relation) = 자바객체 + 테이블(안에있는 recode) 이 2개를 Object로 Mapping 하는것
//next()가 호출될때마다 첫번째 recode에서  두번째 recode로 커서이동 + recode가 있으면 true, 값이 없으면 false 리턴


*/