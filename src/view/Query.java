package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * 查询普通、已销户、已锁定的用户
 * @author mx
 *
 */
public class Query extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		//显示信息，选择要查询的用户状态
				try {
					CommonUtils.printFromProp("N016");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//输入选择状态
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				int param=sc.nextInt();
				Operation op=new Operation();
				op.judge(param);
				
				//返回菜单
				request.setDispatherPath("Menu_Admin");
		
	}
}
