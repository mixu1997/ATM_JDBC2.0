package ui;

import java.io.File;
import java.util.Scanner;
import tool.AbstractView;
import tool.ReadDisplay;
import tool.RequestMap;

/**
 * ѡ�����Աor�û���¼����
 * @author mx
 *
 */
public class Login extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
	
			ReadDisplay.readDisplay("uiTest" + File.separator + "login.txt");
		//�������������ж�Ҫ������һ��
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in); 
			String param=sc.next();
			if("1".equals(param)) {//���������1���������Ա����
				 request.setDispatherPath("Admin_Register");
			}
			else if("2".equals(param)) {//���������2��������ͨ�û�����
				request.setDispatherPath("User_Register");
			}
			else {
	            request.setDispatherPath("Login");
	        }	
	}
}
