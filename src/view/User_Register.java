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

//��ͨ�û���¼
public class User_Register extends AbstractView{
	
	private static String account;
	private static String password;
	 Scanner input =new Scanner(System.in);

	@Override
	public void view(RequestMap<?, ?> request) {
		while(true) {
		try {
				//��ʾ��Ϣ�������˺�
				try {
					CommonUtils.printFromProp("N023");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				account= EnterAccount.enterAccount();
				//��ʾ��Ϣ����������
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
			
				// ��ȡִ��sql��statement����
				Statement statement = con.createStatement();
				String sql="select account,password from menu_user where account=? and password=?"; 
				PreparedStatement ptmt=con.prepareStatement(sql); 
				ptmt.setString(1, account); 
				ptmt.setString(2, password); 
				ResultSet rs=ptmt.executeQuery(); 
				
				//�ж��û�״̬�Ƿ�����
				Operation op=new Operation();
				int state=op.State(EnterAccount.getAccount());
				if(state==1) {
					//�ӵ�¼�û��������˺�����������ѯ�����ݿ�����Ƿ������ͬ���˺����� 
					if(rs.next()/*&&state==1*/){ 
						request.setDispatherPath("Menu_User");
						break;
					}else { 
						//��ʾ��Ϣ��������������������
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
