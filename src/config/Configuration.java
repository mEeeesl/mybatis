package config;
				import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {    // ★ ★ src - configuratoin + res - sqlMapConfig.xml == config들어가면 패키지를 / / / / < 로 나눔
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			/* ▼ 초기버전
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //Factory 객체를 얻음..?
			*/
			
			// ▼ hr 버전
			InputStream stream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "hr");
			
		} catch(Exception e) {}
	}
	
	// 실행시 최초 1회만 실행되는 static 메소드 ▲ 앱실행시 읽어서 sqlMapConfig 실행되서 진행
	// 반복적으로 실행할 메소드 ▼
	
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
		//true를 주면, 이 세션을 통해서 dml이? 오라클로 보내지고, 리스판스로 성공했단 메시지를 받게되면 자동으로 커밋됨
		//메인에서 getMapper하면 이 openSession이 호출되는거
	}
}

/*
 * 
 * 
 * 
 */

