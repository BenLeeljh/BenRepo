package cn.itheima.crm.controller;

import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.crm.po.User;
import cn.itheima.crm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 注入service
	@Autowired
	private UserService usersService;
	@RequestMapping("/touser")
//	@ResponseBody
	public String toUser(){

		//model.addAttribute("userList",userList);
		return "/users";
		
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<User> queryAll(){
		
		List<User> userList=this.usersService.queryAll();
		
		return userList;
		
	}
	@RequestMapping("/user-add")
	public String userAdd(){
		return "/user-add";
		
	}
	@RequestMapping("/save")
	public String addUser(User user){
		usersService.addUser(user);
		return "redirect:/user/touser";
	}
	
	// 根据客户id查询客户信息
	@RequestMapping("/queryUserById")
	public String queryUserById(Model model, Integer id) {
		//查询用户信息
        User user = usersService.queryUserById(id);
        model.addAttribute("user",user);
		return "/user-edit";
	}
	
	@RequestMapping("/updateUser")
	public String updateUserById(User user){
		usersService.updateUserById(user);
		return "redirect:/user/touser";
	}
	
	@RequestMapping("/deleteUserByIds")
	public String deleteUserByIds(Integer[] ids){
		usersService.deleteUserByIds(ids);
		return "redirect:/user/touser";
	}
	
}
