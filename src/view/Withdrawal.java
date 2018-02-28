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
 * ȡ��
 * @author mx
 *
 */
public class Withdrawal extends AbstractView{
	

	private double money;
	private double money1;

	@Override
	public void view(RequestMap<?, ?> request) {
		
		Operation op=new Operation();
		
		//��ȡ��¼ʱ���˻�
		String account=EnterAccount.getAccount();
		
		//��ʾ��Ϣ������ȡ����
		while(true) {
			try {
				CommonUtils.printFromProp("N027");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�ж��������Ƿ�Ϊ����
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
			
			//���������Ա����
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
		//��ȡ����ʱ��
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//��������Ϊ2ȡ��
		int type=2;
		 
		//����
		int serial=op.key1();
		
		//�������ݿ�
		User user=new User(serial,account,null,type,time,this.money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("M004");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���ز˵�
		request.setDispatherPath("Menu_User");
	}

}
