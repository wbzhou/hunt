package mybatis.test;

import java.io.Reader;
import java.util.List;

import mybatis.dao.IUserOperation;
import mybatis.pojo.Article;
import mybatis.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author mike.gu
 * @version 2015年4月3日 下午4:26:37
 * 
 */

public class Test2 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
//		getUserById(1);
//		getUserList("e");
//		addUser();
//		updateUser();
//		deleteUser(6);
		getArticle(1);
	}

	private static void getUserById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(id);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

	public static void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsers("%" + userName + "%");
			for (User user : users) {
				System.out.println(user.getId() + "\t" + user.getUserName()
						+ "\t" + user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}
	
	public static void addUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = new User();
			user.setUserAddress("杭州");
			user.setUserAge("19");
			user.setUserName("lily");
			userOperation.addUser(user);
			session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
		} finally {
			session.close();
		}
	}
	public static void deleteUser(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(5);
			user.setUserAddress("北asdfasfasdfas京");
			user.setUserAge("18");
			user.setUserName("hualalallala");
			userOperation.updateUser(user);
			session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
		} finally {
			session.close();
		}
	}
	
	public static void getArticle(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<Article> articles1 = userOperation.getArticlesByUsetId(id);
			List<Article> articles2 = userOperation.getArticlesByUsetId2(id);
			System.out.println(articles1);
			System.out.println(articles2);
		} finally {
			session.close();
		}
	}
}
