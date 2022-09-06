package config;
				import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {    // �� �� src - configuratoin + res - sqlMapConfig.xml == config���� ��Ű���� / / / / < �� ����
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			/* �� �ʱ����
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //Factory ��ü�� ����..?
			*/
			
			// �� hr ����
			InputStream stream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "hr");
			
		} catch(Exception e) {}
	}
	
	// ����� ���� 1ȸ�� ����Ǵ� static �޼ҵ� �� �۽���� �о sqlMapConfig ����Ǽ� ����
	// �ݺ������� ������ �޼ҵ� ��
	
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
		//true�� �ָ�, �� ������ ���ؼ� dml��? ����Ŭ�� ��������, �����ǽ��� �����ߴ� �޽����� �ްԵǸ� �ڵ����� Ŀ�Ե�
		//���ο��� getMapper�ϸ� �� openSession�� ȣ��Ǵ°�
	}
}

/*
 * 
 * 
 * 
 */

