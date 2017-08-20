package cn.itheima.mapper;

import org.apache.ibatis.annotations.Select;

import cn.itheima.po.User;

public interface UserMapper {
	
	// 根据用户Id查询用户
	User queryUserById(int id);
	
	// 新增用户
	void insertUser(User user);
	
	// 使用注解方式实现根据用户Id查询用户
		@Select("select * from `user` where id=#{id}")
		User queryUserById_1(int id);
}
