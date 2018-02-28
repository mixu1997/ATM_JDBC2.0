package ui;

import java.io.File;
import java.util.Scanner;
import tool.AbstractView;
import tool.ReadDisplay;
import tool.RequestMap;

/**
 * 选择管理员or用户登录界面
 * @author mx
 *
 */
public class Login extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
	
			ReadDisplay.readDisplay("uiTest" + File.separator + "login.txt");
		//根据输入数字判断要进行哪一步
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in); 
			String param=sc.next();
			if("1".equals(param)) {//如果输入是1，进入管理员界面
				 request.setDispatherPath("Admin_Register");
			}
			else if("2".equals(param)) {//如果输入是2，进入普通用户界面
				request.setDispatherPath("User_Register");
			}
			else {
	            request.setDispatherPath("Login");
	        }	
	}
}
