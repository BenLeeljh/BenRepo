package cn.itheima.crm.service;

import java.util.List;

import cn.itheima.crm.po.User;

public interface UserService {
   //查询全部信息
	List<User> queryAll();
	//添加用户信息
	void addUser(User user);
	//根据id查询用户信息
	User queryUserById(Integer id);
	void updateUserById(User user);
	void deleteUserByIds(Integer[] ids);
}
