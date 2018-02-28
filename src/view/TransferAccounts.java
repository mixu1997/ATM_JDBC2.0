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
 * ת��-֧��
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
		
		//��ȡ��¼ʱ���˻�
		String account=EnterAccount.getAccount();
		
		//��ʾ��Ϣ������ת�˵��˻�,���ж��˻��Ƿ����
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
			
		//��ʾ��Ϣ������ת�˿���
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
			
			
			//���������Ա����
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
		//��ȡ����ʱ��
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//��������Ϊ3ת��-֧��
		int type=3;
		 
		//����
		int serial=op.key1();
		
		//�������ݿ�
		User user=new User(serial,account,zaccount,type,time,money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("N033");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ת���������Ϣ�������ݿ�
		TransferAccounts1 ta=new TransferAccounts1();
		ta.income(account,zaccount,money1);
				
		
		//���ز˵�
		request.setDispatherPath("Menu_User");
	 }
}
