<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="padding:10px 10px 10px 10px">
	<form id="content" method="post">
	    <table cellpadding="5">
	    	
	        <tr>
	            <td>用户名:</td>
	            <td>
	            <input name="id" value="${user.id}" style="display: none"></input>
	            <input class="easyui-textbox" type="text" name="user_name" data-options="required:true" value="${user.user_name}" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" type="password" name="password" data-options="required:true" value="${user.password}" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" name="name" data-options="validType:'length[0,150]',required:true" value="${user.name}" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>年龄:</td>
	            <td><input class="easyui-numberbox" type="text" name="age" data-options="min:1,max:100,precision:0,required:true" value="${user.age}"/>
	            </td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="sex" value="1" <c:if test="${user.sex==1 }">checked="checked"</c:if>/> 男
	            	<input class="easyui-radio" type="radio" name="sex" value="2" <c:if test="${user.sex==2 }">checked="checked"</c:if>/> 女
	            </td>
	        </tr>
	        <tr>
	            <td>出生日期:</td>
	            <td>
	                <input class="easyui-datebox" type="text" name="birthday" data-options="required:true" value="${user.birthday}" />
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#content').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.ajax({
		   type: "POST",
		   url: "/ssmTest/user/updateUser.action",
		   data: $("#content").serialize(),
		   success: function(){
			   $.messager.alert('提示','更改会员成功!');
				$('#userEdit').dialog('close');
				$("#userList").datagrid("reload");
				clearForm();
		   },
		   statusCode:{
			   500:function(){
				   $.messager.alert('提示','更改会员失败!');
			   }
		   }
		});
		
	}
</script>