package view;

import com.feicuiedu.User;

import database.Operation;
import tool.AcquisitionTime;

/**
 * 
 * @author mx转账-收入
 *
 */
public class TransferAccounts1 {
	public void income(String account1,String account2,double money1) {
		
		Operation op=new Operation();
		
		double money=money1+op.money(account2);
		
		//将余额传入管理员表中
		op.balance(account2, money); 
		
		//获取交易时间
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//交易类型为4:转账-收入 
		int type=4;
		 
		//主键
		int serial=op.key1();
		
		//加入数据库
		User user=new User(serial,account2,account1,type,time,money);
		op.deal(user);
		
	}
}
