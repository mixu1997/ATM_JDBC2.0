package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.feicuiedu.User;
/**
 * ʵ�ֶ����ݿ�Ĳ���
 * @author mx
 *
 */
public class Operation {
	@SuppressWarnings("unused")
	private int maxid;
	private String sex1;
	private String name;
	private String type1;
	private int state;
	//��������
	public void interposition(User user) {
		
		try {

			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��PreparedStatement����
			String sql = "insert into menu_user       \r\n"
					+ "      (id, name,idcard,sex,birth,site,account,password,balance)\r\n"
					+ "value (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getIdcard());
			statement.setString(4, user.getSex());
			statement.setString(5, user.getBirth());
			statement.setString(6, user.getSite());
			statement.setString(7, user.getAccount());
			statement.setString(8, user.getPassword());
			statement.setDouble(9, user.getBalance());
			
			// ִ��sql���,���ؽ�� -- ����
			@SuppressWarnings("unused")
			int rsCount = statement.executeUpdate();
			
			// �ر���Դ
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * ȡ���������ֵ����һ
	 *  
	 */
	public int key() {
			int maxid=0;
			try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "select max(id) from menu_user";
			// ִ��sql���,���ؽ�� -- ��ѯ
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				maxid=rs.getInt("MAX(id)");
			}
			
			// �ر���Դ
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return maxid+1;
	}
	
	//�޸��û�״̬����
	public void WriteOff(String account1 ,int x) {
		
		try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "update menu_user set State = '"+x+"' where account ='"+account1+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
            statement.executeUpdate(sql);
			//ȡ��״̬
			
			// �ر���Դ
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ж��˻���״̬��1Ϊ�����û���0Ϊ�����û���2Ϊ�����û�,��������Ӧ��״̬�û���ѯ
	public void judge(int i) {
		
			try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "select * from menu_user  where state ='"+i+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
			ResultSet rs = statement.executeQuery(sql);
			//ȡ��״̬
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String idcard = rs.getString(3);
				int sex = rs.getInt("sex");
				String account=rs.getString("account");
				double balance=rs.getDouble("balance");
				if(sex==1) {
					this.sex1="��";
				}
				else {
					this.sex1="Ů";
				}
				System.out.println("����:"+id+",����:"+name+",���֤����:"+idcard+",�Ա�:"+sex1+",����:"+account+",���:"+balance);
			}
			
			
			// �ر���Դ
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//�޸�����
	public void passwd(String account1,String password1) {
		
		try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "update menu_user set password = '"+password1+"' where account ='"+account1+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
            statement.executeUpdate(sql);
			//ȡ��״̬
			
			// �ر���Դ
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ͨ�û�����ʱ�������ݿ������
	public void deal(User user) {
		
		try {

			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��PreparedStatement����
			String sql = "insert into menu_deal       \r\n"
					+ "      (serial, startAccount,targetAccount,type,tradingHour,money)\r\n"
					+ "value (?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, user.getSerial());
			statement.setString(2, user.getStartAccount());
			statement.setString(3, user.getTargetAccount());
			statement.setInt(4, user.getType());
			statement.setString(5, user.getTradingHour());
			statement.setDouble(6, user.getMoney());
			
			// ִ��sql���,���ؽ�� -- ����
			@SuppressWarnings("unused")
			int rsCount = statement.executeUpdate();
			
			// �ر���Դ
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ˮ��
	public int key1() {
		int maxid=0;
		try {
		// ע������,��������
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// ��ȡִ��sql��statement����
		Statement statement = con.createStatement();
		String sql = "select max(serial) from menu_deal";
		// ִ��sql���,���ؽ�� -- ��ѯ
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			
			maxid=rs.getInt("MAX(serial)");
		}
		
		// �ر���Դ
		rs.close();
		statement.close();
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return maxid+1;
	}
	
	//ȡ�����ݿ��еĽ�������м���
	public int money(String account) {
		
		int balance=0;
		try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "select * from menu_user where account ='"+account+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
			ResultSet rs = statement.executeQuery(sql);
			//ȡ��״̬
			while (rs.next()) {
				balance=rs.getInt("balance");
			}
			
			
			// �ر���Դ
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
		
	}
	
	//�޸����
	public void balance(String account1,double balance) {
		
		try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "update menu_user set balance = '"+balance+"' where account ='"+account1+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
            statement.executeUpdate(sql);
			//ȡ��״̬
			
			// �ر���Դ
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ж��û��Ƿ����
	public boolean userIs(String account) {
		boolean bl=true;
		try {
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "select * from menu_user  where account ='"+account+"'";
			// ִ��sql���,���ؽ�� -- ��ѯ
			ResultSet rs = statement.executeQuery(sql);
			//ȡ��״̬
			while (rs.next()) {
				this.name = rs.getString(2);
			}
			if(name.equals("")||name.equals(null)) {
				bl=false;
			}
			else {
				bl=true;
			}
			
			// �ر���Դ
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bl;
		
	}
	
	//�û���ѯ
	public void user_judge(String account) {
		
		try {
		// ע������,��������
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// ��ȡִ��sql��statement����
		Statement statement = con.createStatement();
		String sql = "select * from menu_deal  where startAccount ='"+account+"'";
		// ִ��sql���,���ؽ�� -- ��ѯ
		ResultSet rs = statement.executeQuery(sql);
		//ȡ��״̬
		while (rs.next()) {
			int serial=rs.getInt("serial");
			String startAccount=rs.getString("startAccount");
			String targetAccount=rs.getString("targetAccount");
			int type=rs.getInt("type");
			String tradingHour=rs.getString("tradingHour");
			double money=rs.getDouble("money");
			if(type==1) {// 1:��� 2:ȡ�� 3: ת��-֧��  4:ת��-���� 
				this.type1="���";
			}
			else if(type==2) {
				this.type1="ȡ��";
			}
			else if(type==3) {
				this.type1="ת��-֧�� ";
			}
			else if(type==4) {
				this.type1="ת��-����  ";
			}
			System.out.println("������ˮ�ţ�"+serial+",Դ�˻�:"+startAccount+",Ŀ���˻�:"+targetAccount+",��������:"+type1+",����ʱ��:"+tradingHour+",�˻���"+money);
		}
		
		
		// �ر���Դ
		rs.close();
		statement.close();
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	//�ж��û�״̬�Ƿ�Ϊ1
	public int State(String account) {
		
		try {
		// ע������,��������
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// ��ȡִ��sql��statement����
		Statement statement = con.createStatement();
		String sql = "select * from menu_user  where account ='"+account+"'";
		// ִ��sql���,���ؽ�� -- ��ѯ
		ResultSet rs = statement.executeQuery(sql);
		//ȡ��״̬
		while (rs.next()) {
			this.state = rs.getInt("state");
		}
		
		
		// �ر���Դ
		rs.close();
		statement.close();
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	
	}
}
