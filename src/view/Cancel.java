package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;
/**
 * �����û�״̬
 * @author mx
 *
 */
public class Cancel extends AbstractView{

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
		//��ʾ��Ϣ������Ҫ�޸ĵ�״̬������1�޸�Ϊ��ͨ�û���0Ϊ�����û���2Ϊ�����û�
		try {
			CommonUtils.printFromProp("N018");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int state=sc.nextInt();
		Operation op=new Operation();
		op.WriteOff(account,state);
		
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
