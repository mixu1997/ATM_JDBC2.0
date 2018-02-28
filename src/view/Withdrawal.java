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
 * 取款
 * @author mx
 *
 */
public class Withdrawal extends AbstractView{
	

	private double money;
	private double money1;

	@Override
	public void view(RequestMap<?, ?> request) {
		
		Operation op=new Operation();
		
		//获取登录时的账户
		String account=EnterAccount.getAccount();
		
		//提示信息，输入取款金额
		while(true) {
			try {
				CommonUtils.printFromProp("N027");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//判断输入金额是否为负数
			while(true) {
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				this.money1=sc.nextDouble();
				this.money=op.money(account)-money1;
				if(money1<0) {
					try {
						CommonUtils.printFromProp("N036");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					break;
				}
			}
			
			//将余额传入管理员表中
			if(op.money(account)>this.money1) {
				op.balance(account, money); 
				break;
			}
			else {
				try {
					CommonUtils.printFromProp("N028");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//获取交易时间
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//交易类型为2取款
		int type=2;
		 
		//主键
		int serial=op.key1();
		
		//加入数据库
		User user=new User(serial,account,null,type,time,this.money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("M004");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回菜单
		request.setDispatherPath("Menu_User");
	}

}
