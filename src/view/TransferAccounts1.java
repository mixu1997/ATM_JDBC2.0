package view;

import com.feicuiedu.User;

import database.Operation;
import tool.AcquisitionTime;

/**
 * 
 * @author mxת��-����
 *
 */
public class TransferAccounts1 {
	public void income(String account1,String account2,double money1) {
		
		Operation op=new Operation();
		
		double money=money1+op.money(account2);
		
		//���������Ա����
		op.balance(account2, money); 
		
		//��ȡ����ʱ��
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//��������Ϊ4:ת��-���� 
		int type=4;
		 
		//����
		int serial=op.key1();
		
		//�������ݿ�
		User user=new User(serial,account2,account1,type,time,money);
		op.deal(user);
		
	}
}
