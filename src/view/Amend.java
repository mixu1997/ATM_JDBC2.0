package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * 修改密码
 * @author mx
 *
 */
public class Amend extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//提示信息，输入要更改的账号
		try {
			CommonUtils.printFromProp("N017");
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		//输入账号
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String account=sc.nextLine();
		
		//提示信息，输入要修改的新密码
		try {
			CommonUtils.printFromProp("N019");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String password=sc.nextLine();
		//进行修改
		Operation op=new Operation();
		op.passwd(account,password);
		//提示信息，修改成功
		try {
			CommonUtils.printFromProp("M002");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回菜单
		request.setDispatherPath("Menu_Admin");
	}
	
}
