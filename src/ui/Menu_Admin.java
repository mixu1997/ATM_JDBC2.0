package ui;

import java.io.File;
import java.util.Scanner;

import tool.AbstractView;
import tool.ReadDisplay;
import tool.RequestMap;
/**
 * 
 * @author mx
 *  管理员登录界面
 */
public class Menu_Admin extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
			//显示菜单信息
			ReadDisplay.readDisplay("uiTest" + File.separator + "menu_admin.txt");
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			String param=sc.next();
			if(param.equals("1")) {//开户
				request.setDispatherPath("Open");
			}
			else if(param.equals("2")) {//查询
				request.setDispatherPath("Query");
			}
			else if(param.equals("3")) {//更改用户状态
				request.setDispatherPath("Cancel");
			}
			else if(param.equals("4")) {//修改密码
				request.setDispatherPath("Amend");
			}
			else if(param.equals("5")) {//返回菜单
				request.setDispatherPath("Login");
			}
	}
}
