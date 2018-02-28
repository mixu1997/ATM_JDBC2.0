package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.feicuiedu.User;
/**
 * 实现对数据库的操作
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
	//插入数据
	public void interposition(User user) {
		
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的PreparedStatement对象
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
			
			// 执行sql语句,返回结果 -- 新增
			@SuppressWarnings("unused")
			int rsCount = statement.executeUpdate();
			
			// 关闭资源
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
	 * 取出主键最大值并加一
	 *  
	 */
	public int key() {
			int maxid=0;
			try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "select max(id) from menu_user";
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				
				maxid=rs.getInt("MAX(id)");
			}
			
			// 关闭资源
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
	
	//修改用户状态所用
	public void WriteOff(String account1 ,int x) {
		
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "update menu_user set State = '"+x+"' where account ='"+account1+"'";
			// 执行sql语句,返回结果 -- 查询
            statement.executeUpdate(sql);
			//取出状态
			
			// 关闭资源
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
	
	//判断账户的状态，1为正常用户，0为锁定用户，2为销户用户,并进行相应的状态用户查询
	public void judge(int i) {
		
			try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "select * from menu_user  where state ='"+i+"'";
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery(sql);
			//取出状态
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String idcard = rs.getString(3);
				int sex = rs.getInt("sex");
				String account=rs.getString("account");
				double balance=rs.getDouble("balance");
				if(sex==1) {
					this.sex1="男";
				}
				else {
					this.sex1="女";
				}
				System.out.println("主键:"+id+",姓名:"+name+",身份证号码:"+idcard+",性别:"+sex1+",卡号:"+account+",余额:"+balance);
			}
			
			
			// 关闭资源
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
	
	//修改密码
	public void passwd(String account1,String password1) {
		
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "update menu_user set password = '"+password1+"' where account ='"+account1+"'";
			// 执行sql语句,返回结果 -- 查询
            statement.executeUpdate(sql);
			//取出状态
			
			// 关闭资源
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
	
	//普通用户操作时存入数据库的数据
	public void deal(User user) {
		
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的PreparedStatement对象
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
			
			// 执行sql语句,返回结果 -- 新增
			@SuppressWarnings("unused")
			int rsCount = statement.executeUpdate();
			
			// 关闭资源
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
	//流水号
	public int key1() {
		int maxid=0;
		try {
		// 注册驱动,创建连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// 获取执行sql的statement对象
		Statement statement = con.createStatement();
		String sql = "select max(serial) from menu_deal";
		// 执行sql语句,返回结果 -- 查询
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			
			maxid=rs.getInt("MAX(serial)");
		}
		
		// 关闭资源
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
	
	//取出数据库中的金额，方便进行计算
	public int money(String account) {
		
		int balance=0;
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "select * from menu_user where account ='"+account+"'";
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery(sql);
			//取出状态
			while (rs.next()) {
				balance=rs.getInt("balance");
			}
			
			
			// 关闭资源
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
	
	//修改余额
	public void balance(String account1,double balance) {
		
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "update menu_user set balance = '"+balance+"' where account ='"+account1+"'";
			// 执行sql语句,返回结果 -- 查询
            statement.executeUpdate(sql);
			//取出状态
			
			// 关闭资源
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
	
	//判断用户是否存在
	public boolean userIs(String account) {
		boolean bl=true;
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "select * from menu_user  where account ='"+account+"'";
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery(sql);
			//取出状态
			while (rs.next()) {
				this.name = rs.getString(2);
			}
			if(name.equals("")||name.equals(null)) {
				bl=false;
			}
			else {
				bl=true;
			}
			
			// 关闭资源
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
	
	//用户查询
	public void user_judge(String account) {
		
		try {
		// 注册驱动,创建连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// 获取执行sql的statement对象
		Statement statement = con.createStatement();
		String sql = "select * from menu_deal  where startAccount ='"+account+"'";
		// 执行sql语句,返回结果 -- 查询
		ResultSet rs = statement.executeQuery(sql);
		//取出状态
		while (rs.next()) {
			int serial=rs.getInt("serial");
			String startAccount=rs.getString("startAccount");
			String targetAccount=rs.getString("targetAccount");
			int type=rs.getInt("type");
			String tradingHour=rs.getString("tradingHour");
			double money=rs.getDouble("money");
			if(type==1) {// 1:存款 2:取款 3: 转账-支出  4:转账-收入 
				this.type1="存款";
			}
			else if(type==2) {
				this.type1="取款";
			}
			else if(type==3) {
				this.type1="转账-支出 ";
			}
			else if(type==4) {
				this.type1="转账-收入  ";
			}
			System.out.println("账务流水号："+serial+",源账户:"+startAccount+",目标账户:"+targetAccount+",账务类型:"+type1+",账务时间:"+tradingHour+",账户余额："+money);
		}
		
		
		// 关闭资源
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
	
	//判断用户状态是否为1
	public int State(String account) {
		
		try {
		// 注册驱动,创建连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
		
		// 获取执行sql的statement对象
		Statement statement = con.createStatement();
		String sql = "select * from menu_user  where account ='"+account+"'";
		// 执行sql语句,返回结果 -- 查询
		ResultSet rs = statement.executeQuery(sql);
		//取出状态
		while (rs.next()) {
			this.state = rs.getInt("state");
		}
		
		
		// 关闭资源
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
