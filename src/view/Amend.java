package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * �޸�����
 * @author mx
 *
 */
public class Amend extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//��ʾ��Ϣ������Ҫ���ĵ��˺�
		try {
			CommonUtils.printFromProp("N017");
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		//�����˺�
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String account=sc.nextLine();
		
		//��ʾ��Ϣ������Ҫ�޸ĵ�������
		try {
			CommonUtils.printFromProp("N019");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password=sc.nextLine();
		//�����޸�
		Operation op=new Operation();
		op.passwd(account,password);
		//��ʾ��Ϣ���޸ĳɹ�
		try {
			CommonUtils.printFromProp("M002");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���ز˵�
		request.setDispatherPath("Menu_Admin");
	}
	
}
