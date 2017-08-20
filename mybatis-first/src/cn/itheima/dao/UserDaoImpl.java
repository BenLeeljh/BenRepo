package cn.itheima.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itheima.po.User;

public class UserDaoImpl implements UserDao {
	// 定义SqlSessionFactory对象
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 
	 * @param sqlSessionFactory
	 */
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		// 创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 使用sqlSession对象调用方法执行
		Object user = sqlSession.selectOne("test.queryUserById", id);
		// 3.释放资源
		sqlSession.close();

		return (User) user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		// 1.创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

		// 2.使用sqlSession对象，调用方法执行
		sqlSession.insert("test.insertUser", user);

		// 3.释放资源
		sqlSession.close();
	}

}
