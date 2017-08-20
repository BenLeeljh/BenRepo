package cn.itheima.crm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.UserMapper;
import cn.itheima.crm.po.User;
import cn.itheima.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    //注入UserMapper
	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userMapper.queryAll();
	}
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
		
	}
	@Override
	public User queryUserById(Integer id) {
		User user = userMapper.queryUserById(id);
		return user;
	}
	@Override
	public void updateUserById(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserById(user);
	}
	@Override
	public void deleteUserByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		userMapper.deleteUserByIds(ids);
	}

}
