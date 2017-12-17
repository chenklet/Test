package mybatis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test171217 {
	public static void main(String[] args) throws FileNotFoundException {
		String config = "mybatis-config.xml";
		FileInputStream resource = new FileInputStream("E:\\git\\Test\\Study\\resources\\" + config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
		SqlSession session = factory.openSession();
		User user = session.selectOne("getUser", 5);
//		TestDAO dao = session.getMapper(TestDAO.class);
//		user = dao.getUser(4);
		System.out.println(user.getUserName());
	}
}
