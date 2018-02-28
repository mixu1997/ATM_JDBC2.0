package view;

import java.io.IOException;
import java.util.Scanner;

import com.feicuiedu.User;

import database.Operation;
import tool.AbstractView;
import tool.AcquisitionTime;
import tool.CommonUtils;
import tool.EnterAccount;
import tool.RequestMap;

/**
 * 存款
 * @author mx
 *
 */
public class Deposit extends AbstractView{
	
	private String startAccount;
	private double money;

	@Override
	public void view(RequestMap<?, ?> request) {
		
		Operation op=new Operation();
		
		//获取登录时的账户
		this.startAccount=EnterAccount.getAccount();
		
		//提示信息，输入存款金额
		try {
			CommonUtils.printFromProp("N025");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断输入金额是否为负数或者大于十万
		while(true) {
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			double money1=sc.nextDouble();
			if(money1>=100000||money1<0) {
				try {
					CommonUtils.printFromProp("N035");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				money=money1+op.money(startAccount);
				break;
			}
		}
		
		
		//将余额传入管理员表中
		op.balance(startAccount, money); 
		
		//获取交易时间
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//交易类型为1存款
		int type=1;
		 
		//主键
		int serial=op.key1();
		
		//加入数据库
		User user=new User(serial,startAccount,null,type,time,this.money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("N026");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回菜单
		request.setDispatherPath("Menu_User");
	}

}
