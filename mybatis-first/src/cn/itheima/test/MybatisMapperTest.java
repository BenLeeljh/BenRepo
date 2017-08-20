package cn.itheima.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itheima.mapper.UserMapper;
import cn.itheima.po.User;

public class MybatisMapperTest {
	
private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		// 1.加载核心配置文件
		InputStream inputStream = Resources
				.getResourceAsStream("sqlMapConfig.xml");

		// 2.读取配置文件内容,得到框架核心对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}
   //测试根据用户id查询用户
	@Test
	public void queryUserByIdTest(){
		// 创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
	
	//使用sqlSession对象 获取mapper代理对象
		//getMapper方法 获取mapper代理对象
		//参数 需要获取代理对象的mapper 接口class
		UserMapper mapper =sqlSession.getMapper(UserMapper.class);
		
		//使用mapper代理对象  调用方法执行
		User user =mapper.queryUserById(4);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	
	}
	// 测试新增用户
		@Test
		public void insertUserTest(){
			// 1.创建sqlSession对象
			SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
			
			// 2.使用sqlSession对象，获取Mapper代理对象
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			// 3.使用mapper代理对象，调用方法执行
			// 创建用户对象
			User user = new User();
			user.setUsername("罗斯");
			user.setSex("1");
			user.setBirthday(new Date());
			user.setAddress("骑士");
			
			System.out.println("执行前："+user);
			mapper.insertUser(user);
			System.out.println("执行后："+user);
			
			// 4.释放资源
			sqlSession.close();
		}
		

		// 测试使用注解方式实现根据用户Id查询用户
		@Test
		public void queryUserById_1Test(){
			
			// 1.创建sqlSession对象
			SqlSession sqlSession = this.sqlSessionFactory.openSession();
			
			// 2.使用sqlSession对象，获取mapper代理对象
			// getMapper方法：获取mapper代理对象
			// 参数：需要获取代理对象的mapper接口class
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			
			// 3.使用mapper代理对象，调用方法执行
			User user = mapper.queryUserById_1(2);
			System.out.println(user);
			
			// 4.释放资源
			sqlSession.close();
			
		}
}
