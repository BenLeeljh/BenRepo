package cn.itheima.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itheima.dao.UserDao;
import cn.itheima.dao.UserDaoImpl;
import cn.itheima.po.User;

public class MybatisDaoTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// 1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

		// 2.读取配置文件内容,得到框架核心对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}

	// 测试根据用户id查询
	@Test
	public void queryUserByIdTest() {
		// 创建用户dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		// 2.使用userDao对象，调用方法执行
		User user = userDao.queryUserById(4);
		System.out.println(user);

	}
	
	//测试新增用户
	@Test
	public void insertUserTest(){
		// 1.创建用户dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		// 2.使用userDao对象，调用方法执行
		// 创建用户对象
		User user = new User();
		user.setUsername("威少");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("雷霆");
		
		System.out.println("执行前："+user);
		userDao.insertUser(user);
		System.out.println("执行后："+user);
		
	}
}
