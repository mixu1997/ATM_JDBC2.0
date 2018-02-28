package ui;

import java.io.File;

import java.util.Scanner;

import tool.AbstractView;

import tool.ReadDisplay;
import tool.RequestMap;

/**
 * �û���¼����
 * @author mx
 *
 */
public class Menu_User extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//��ʾѡ���¼����
		ReadDisplay.readDisplay("uiTest" + File.separator + "menu_user.txt");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String param=sc.next();
		if(param.equals("1")) {//���
			request.setDispatherPath("Deposit");
		}
		else if(param.equals("2")) {//ȡ��
			request.setDispatherPath("Withdrawal");
		}
		else if(param.equals("3")) {//ת��
			request.setDispatherPath("TransferAccounts");
		}
		else if(param.equals("4")) {//��ѯ
			request.setDispatherPath("User_Query");
		}
		else if(param.equals("5")) {//���ز˵�
			request.setDispatherPath("Login");
		}
		
	}
}
