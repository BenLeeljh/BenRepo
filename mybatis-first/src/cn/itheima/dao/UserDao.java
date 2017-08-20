package cn.itheima.dao;

import cn.itheima.po.User;

public interface UserDao {
//根据用户id查询用户
	User queryUserById(int id);
	
	// 新增用户
	void insertUser(User user);
}
