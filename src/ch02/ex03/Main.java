package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
				// insertUser�� ����Ÿ���� int
		/* - - - - - - -
		if(mapper.insertUser(new User(11, "abel", LocalDate.now())) > 0)
			System.out.println("���� 11");
		*/
		
		/*
		 11�� ������ ���»��¿��� ����� - ���� 11
		 �� �����Ű�� Error MYBATIS.USER_USERID_PK violated
		 PK Ű�� �����ѵ� 11���� �� ����� ����
		 developer���� ���� ��Ű�� �ٽ� �����Ű�� - ���� 11
		*/
		
		/* - - - - - - -
		if(mapper.insertUser(new User(12, null, null)) > 0)
			System.out.println("���� 12");
		*/
		
		/* Error - null�� �ȴ� 
		null �������� Map���� ������ �����ؾ��� 
		#{userId, jdbcType=NUMERIC},
		#{userName, jdbcType=VARCHAR},
		#{regDate, jdbcType=DATE}
		*/
		
		/* - - - - - - - -
		if(mapper.insertUser2(13,"kianu", LocalDate.of(2022, 8, 15)) > 0)
			System.out.println("���� 13");
		*/	
			
		/*
		 Error Parameter 'userId' not found. == #{userId}�� ��ã��,
		 @Param("userId / userName / regDate") �̰� �ٿ��ָ� ã�� 
		 */
		
		if(mapper.insertUser3(14, "neo", LocalDate.now()) > 0)
			System.out.println("���� 14");
		// �� insertUser3 ����� �� �Ⱦ��� ���
	}
}
/*
�����Ű�� Developer���� �߰��� ���� �� �� �ִ�.

*/