package view;
import java.io.IOException;
import java.util.Scanner;

import com.feicuiedu.User;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * 开户
 * @author mx
 *
 */
public class Open extends AbstractView{
	//主键
	private int id;
	//姓名
	private String name;
	//身份证号
	private String idcard;
	//性别
	private String sex;
	//出生日期
	private String birth;
	//地址
	private String site;
	//账户
	private String account;
	//密码
	private String password;
	//余额
	private double balance=0.0;
		
	@Override
	public void view(RequestMap<?, ?> request) {
		@SuppressWarnings("resource")
		Scanner sca=new Scanner(System.in);
		//设置主键
		Operation op=new Operation();
		this.id=op.key();

		while(true) {//输入姓名
			
			try {
				
				CommonUtils.printFromProp("N003");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.name = sca.next();
			
			if(!name.matches("^.{1,10}$")) {
				
				try {
					
					CommonUtils.printFromProp("N004");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				break;
			}
		}
		
		while (true) {//输入身份证号
			
			try {
				CommonUtils.printFromProp("N007");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.idcard = sca.next();
			//15位到18位数字
			try {
				CommonUtils.printFromProp("N014");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (!idcard.matches("^\\d{15}|\\d{18}$")) {
				
				try {
					
					CommonUtils.printFromProp("N008");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else {
				
				break;
			}
		}
		
		while (true) {//选择性别
			
			try {
				
				CommonUtils.printFromProp("N005");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String param = sca.next();
			//输入1时为男
			if (param.equals("1")) {
				
				this.sex = "01";
				break;
			} 
			//输入2时为女
			else if (param.equals("2")) {
				
				this.sex = "02";
				break;
			} 
			else {
				
				try {
					CommonUtils.printFromProp("N006");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
		while (true) {//输入出生日期
			try {
				CommonUtils.printFromProp("N009");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
																
			this.birth = sca.next();
			try {
				CommonUtils.printFromProp("N013");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!birth.matches("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?" +"[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +"|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +"(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12" +"35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[" +"1-9])|(1[0-9])|(2[0-8]))))))")) {
				
				try {
					CommonUtils.printFromProp("N010");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				break;
			}
		}
		
		while (true) {//输入地址
			try {
				CommonUtils.printFromProp("N011");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.site = sca.next();
			if (site.length() > 150) {
				try {
					CommonUtils.printFromProp("N012");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.site = sca.next();
			} 
			else {
				break;
			}
		}
		
		//四位随机数
		int param=(int)((Math.random()*9+1)*1000); 
		//生成账号，账号格式：BC18 + 性别(男01:女02)  + 出生日期 + 4位随机号
		this.account = "BC18" + sex + birth + param;
		System.out.println("您的账号是："+account);
		
		while (true) {//设置密码
			try {
				CommonUtils.printFromProp("N001");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String password0= sca.next();
			if (!password0.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")) {
					try {
						CommonUtils.printFromProp("N002");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} 
			else {
				try {
					CommonUtils.printFromProp("N001");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.password= sca.next();
				if(password.equals(password0)) {
					break;
				}
				else {
					try {
						CommonUtils.printFromProp("N002");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		id = op.key();
		User user = new User(id,name,idcard, sex, birth, site,balance, account,password);
		
		try {
			CommonUtils.printFromProp("M001");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//存入数据库

		op.interposition(user);
		//返回菜单
		request.setDispatherPath("Menu_Admin");
		
	}
}