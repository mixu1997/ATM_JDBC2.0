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
 * ���
 * @author mx
 *
 */
public class Deposit extends AbstractView{
	
	private String startAccount;
	private double money;

	@Override
	public void view(RequestMap<?, ?> request) {
		
		Operation op=new Operation();
		
		//��ȡ��¼ʱ���˻�
		this.startAccount=EnterAccount.getAccount();
		
		//��ʾ��Ϣ����������
		try {
			CommonUtils.printFromProp("N025");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж��������Ƿ�Ϊ�������ߴ���ʮ��
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
		
		
		//���������Ա����
		op.balance(startAccount, money); 
		
		//��ȡ����ʱ��
		AcquisitionTime at=new AcquisitionTime();
		String time=at.time();
		
		//��������Ϊ1���
		int type=1;
		 
		//����
		int serial=op.key1();
		
		//�������ݿ�
		User user=new User(serial,startAccount,null,type,time,this.money);
		op.deal(user);
		try {
			CommonUtils.printFromProp("N026");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���ز˵�
		request.setDispatherPath("Menu_User");
	}

}
