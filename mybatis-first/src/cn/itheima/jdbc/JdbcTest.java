package cn.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
/**
 * jdbc:示例程序
 * @param args
 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet set = null;
    //加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建数据库连接对象
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
			//定义sql
			String sql = "Select *  from  user  where id =?";
			//创建一个statement语句对象
			psmt = con.prepareStatement(sql);
			//设置参数
			psmt.setInt(1,10);
			//执行
		set=psmt.executeQuery();
			//处理结果
			while(set.next()){
				System.out.println("用户id:"+set.getInt("id")+",用户名称:"+set.getString("username"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//8.释放资源
				try {
					if(set !=null) {
					set.close();
					}
					if(psmt !=null){
						psmt.close();
					}
					if(con!=null){
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
	}

}
