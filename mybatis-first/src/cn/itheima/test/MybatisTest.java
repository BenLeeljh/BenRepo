package cn.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itheima.po.User;

public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// 1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

		// 2.读取配置文件内容,得到框架核心对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}

	@Test
	public void queryUserByIdTest() throws IOException {
		// 加载核心配置文件：sqlMapConfig.xml
		// 参数resource 指定配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// sqlSessionFactory对象 mybatis框架核心对象，一个应用中需要存在一个
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		// 使用sqlSessionFactory对象，创建sqlSession对象
		// sqlSession对象是线程不安全的每一个方法一个对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 使用sqlSession对象 完成数据库操作
		// selectOne 方法 查询单条记录
		// 参数一 执行的sql语句 ID （名称空间+sql语句Id）
		// 参数二：参数值
		Object user = sqlSession.selectOne("test.queryUserById", 10);
		System.out.println(user);
		// 释放资源
		sqlSession.close();

	}

	@Test
	public void queryUserByNameTest() throws Exception {
		// 加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 读取配置文件内容 得到框架核心对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		;
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		// 使用 sqlSessionFactory对象 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 4.使用sqlSession对象，调用方法执行
		// selectList方法：查询多条记录
		// 参数一：执行的sql语句Id(名称空间+sql语句Id)
		// 参数二：传入的参数值
		List<Object> list = sqlSession.selectList("test.queryUserByName", "小");
		for (Object object : list) {
			System.out.println(object);
		}
		sqlSession.close();
	}

	@Test
	public void insertUserTest() {
		// 创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		// 2.使用sqlSession对象，调用方法执行
		// insert方法：新增记录
		// 参数一：执行的sql语句Id（名称空间+sql语句Id）
		// 参数二：传入的参数值
		// 创建用户对象
		User user = new User();
		//user.setId(4);
		user.setUsername("Berserker");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("希腊");
		System.out.println("执行前："+user);
		sqlSession.insert("test.insertUser", user);
		System.out.println("执行后："+user);
		// 数据库中提交事务：commit
		// 手动提交事务
		//sqlSession.commit();
		// 3.释放资源
		sqlSession.close();
	}
	
	// 测试根据用户Id修改用户
		@Test
		public void updateUserByIdTest(){
			// 1.创建sqlSession对象
			SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
			
			// 2.使用sqlSession对象，调用方法执行
			// update方法：修改记录
			//参数一：执行的sql语句Id(名称空间+sql语句Id)
			// 参数二：传入的参数值
			// 创建用户对象
			User user = new User();
			user.setId(3);
			user.setUsername("燕洵和楚乔");
			user.setSex("2");
			
			sqlSession.update("test.updateUserById", user);
			
			// 释放资源
			sqlSession.close();
		}
		// 测试根据用户Id删除用户
		@Test
		public void deleteUserByIdTest(){
			// 1.创建sqlSession对象
			SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
			
			// 2.使用sqlSession对象，调用方法执行
			// delete方法：删除记录
			// 参数一：执行的sql语句id（名称空间+sql语句Id）
			// 参数二：传入的参数值
			sqlSession.delete("test.deleteUserById", 38);
			
			// 3.释放资源
			sqlSession.close();
		}
}
