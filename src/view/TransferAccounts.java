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
 * 转账-支出
 * @author mx
 *
 */
public class TransferAccounts extends AbstractView{

	private double money;
	private String zaccount;
	private double money1;

	 @Override
	public void view(RequestMap<?, ?> request) {
		 
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		Operation op=new Operation();
		
		//获取登录时的账户
		String account=EnterAccount.getAccount();
		
		//提示信息，输入转账的账户,并判断账户是否存在
		while(true) {
			try {
				CommonUtils.printFromProp("N029");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.zaccount=sc.nextLine();
			boolean bl=op.userIs(zaccount);
			if(bl==true) {
				break;
			}
			else {
				try {
					CommonUtils.printFromProp("N030");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		//提示信息，输入转账款金额
		while(true) {
			try {
				CommonUtils.printFromProp("N032");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(true) {
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
			if(op.money(account)>money1) {
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
		
		//交易类型为3转账-支出
		int type=3;
		 
		//主键
		int serial=op.key1();
		
		//加入数据库
		User user=new User(serial,account,zaccount,type,time,money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("N033");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//把转账收入的信息存入数据库
		TransferAccounts1 ta=new TransferAccounts1();
		ta.income(account,zaccount,money1);
				
		
		//返回菜单
		request.setDispatherPath("Menu_User");
	 }
}
