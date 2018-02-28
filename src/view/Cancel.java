package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;
/**
 * 更改用户状态
 * @author mx
 *
 */
public class Cancel extends AbstractView{

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
		//提示信息，输入要修改的状态，输入1修改为普通用户，0为锁定用户，2为销户用户
		try {
			CommonUtils.printFromProp("N018");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int state=sc.nextInt();
		Operation op=new Operation();
		op.WriteOff(account,state);
		
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
