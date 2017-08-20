package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.User;

public interface UserMapper {
  //查询全部用户信息
	List<User> queryAll();
	//添加用户信息
	void addUser(User user);
	//根据用户id查找用户信息
	User queryUserById(Integer id);
	//更新
	void updateUserById(User user);
	//
	void deleteUserByIds(Integer[] ids);
	
}
