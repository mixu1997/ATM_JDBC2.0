package ui;

import java.io.File;

import java.util.Scanner;

import tool.AbstractView;

import tool.ReadDisplay;
import tool.RequestMap;

/**
 * 用户登录界面
 * @author mx
 *
 */
public class Menu_User extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//显示选择登录界面
		ReadDisplay.readDisplay("uiTest" + File.separator + "menu_user.txt");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String param=sc.next();
		if(param.equals("1")) {//存款
			request.setDispatherPath("Deposit");
		}
		else if(param.equals("2")) {//取款
			request.setDispatherPath("Withdrawal");
		}
		else if(param.equals("3")) {//转账
			request.setDispatherPath("TransferAccounts");
		}
		else if(param.equals("4")) {//查询
			request.setDispatherPath("User_Query");
		}
		else if(param.equals("5")) {//返回菜单
			request.setDispatherPath("Login");
		}
		
	}
}
