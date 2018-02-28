package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.EnterAccount;
import tool.RequestMap;

//普通用户登录
public class User_Register extends AbstractView{
	
	private static String account;
	private static String password;
	 Scanner input =new Scanner(System.in);

	@Override
	public void view(RequestMap<?, ?> request) {
		while(true) {
		try {
				//提示信息，输入账号
				try {
					CommonUtils.printFromProp("N023");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				account= EnterAccount.enterAccount();
				//提示信息，输入密码
				try {
					CommonUtils.printFromProp("N024");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				password=input.next();
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
				// 获取执行sql的statement对象
				Statement statement = con.createStatement();
				String sql="select account,password from menu_user where account=? and password=?"; 
				PreparedStatement ptmt=con.prepareStatement(sql); 
				ptmt.setString(1, account); 
				ptmt.setString(2, password); 
				ResultSet rs=ptmt.executeQuery(); 
				
				//判断用户状态是否正常
				Operation op=new Operation();
				int state=op.State(EnterAccount.getAccount());
				if(state==1) {
					//从登录用户给出的账号密码来检测查询在数据库表中是否存在相同的账号密码 
					if(rs.next()/*&&state==1*/){ 
						request.setDispatherPath("Menu_User");
						break;
					}else { 
						//提示信息，输入有误，请重新输入
						try {
							CommonUtils.printFromProp("N006");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else {
					try {
						CommonUtils.printFromProp("N034");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}

}
