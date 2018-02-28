package ui;

import java.io.File;
import java.util.Scanner;

import tool.AbstractView;
import tool.ReadDisplay;
import tool.RequestMap;
/**
 * 
 * @author mx
 *  ����Ա��¼����
 */
public class Menu_Admin extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
			//��ʾ�˵���Ϣ
			ReadDisplay.readDisplay("uiTest" + File.separator + "menu_admin.txt");
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			String param=sc.next();
			if(param.equals("1")) {//����
				request.setDispatherPath("Open");
			}
			else if(param.equals("2")) {//��ѯ
				request.setDispatherPath("Query");
			}
			else if(param.equals("3")) {//�����û�״̬
				request.setDispatherPath("Cancel");
			}
			else if(param.equals("4")) {//�޸�����
				request.setDispatherPath("Amend");
			}
			else if(param.equals("5")) {//���ز˵�
				request.setDispatherPath("Login");
			}
	}
}
