import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import tool.CommonUtils;
import tool.EnterAccount;
/**
 * 测试
 * @author mx
 *
 */
public class MainTest {

	private static String account;
	private static String password;
	private static String type1;
	 static Scanner input =new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		try {
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			String sql = "select * from menu_deal  where startAccount ='BC18021998-03-226638'";
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery(sql);
			//取出状态
			while (rs.next()) {
				int serial=rs.getInt("serial");
				String startAccount=rs.getString("startAccount");
				String targetAccount=rs.getString("targetAccount");
				int type=rs.getInt("type");
				String tradingHour=rs.getString("tradingHour");
				int money=rs.getInt("money");
				if(type==1) {// 1:存款 2:取款 3: 转账-支出  4:转账-收入 
					type1="存款";
				}
				else if(type==2) {
					type1="取款";
				}
				else if(type==3) {
					type1="转账-支出 ";
				}
				else if(type==3) {
					type1="转账-收入  ";
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
}