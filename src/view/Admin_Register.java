package view;

import java.io.IOException;
import java.util.Scanner;

import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * ����Ա��֤��¼
 * @author mx
 *
 */
public class Admin_Register extends AbstractView{
	
	@Override
	public void view(RequestMap<?, ?> request) {
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
		    //��ʾ��Ϣ�������˻�
			try {
				CommonUtils.printFromProp("N020");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String account=sc.nextLine();
				
			//��ʾ��Ϣ����������
			try {
				CommonUtils.printFromProp("N022");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String password=sc.nextLine();
			
			//������ȷ
			if(account.equals("admin")&&password.equals("123456")) {
				request.setDispatherPath("Menu_Admin");
				break;
			}
			
			//�������
			else {
				try {
					CommonUtils.printFromProp("N030");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
