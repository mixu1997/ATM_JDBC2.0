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
 * ����
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
			// ע������,��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
			
			// ��ȡִ��sql��statement����
			Statement statement = con.createStatement();
			String sql = "select * from menu_deal  where startAccount ='BC18021998-03-226638'";
			// ִ��sql���,���ؽ�� -- ��ѯ
			ResultSet rs = statement.executeQuery(sql);
			//ȡ��״̬
			while (rs.next()) {
				int serial=rs.getInt("serial");
				String startAccount=rs.getString("startAccount");
				String targetAccount=rs.getString("targetAccount");
				int type=rs.getInt("type");
				String tradingHour=rs.getString("tradingHour");
				int money=rs.getInt("money");
				if(type==1) {// 1:��� 2:ȡ�� 3: ת��-֧��  4:ת��-���� 
					type1="���";
				}
				else if(type==2) {
					type1="ȡ��";
				}
				else if(type==3) {
					type1="ת��-֧�� ";
				}
				else if(type==3) {
					type1="ת��-����  ";
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
}