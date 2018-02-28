package view;

import database.Operation;
import tool.AbstractView;
import tool.EnterAccount;
import tool.RequestMap;
/**
 * 
 * @author mx  用户查询
 *
 */
public class User_Query extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//获取登录时的账户
		String account=EnterAccount.getAccount();
		
		Operation op=new Operation();
		op.user_judge(account);
		request.setDispatherPath("Menu_User");
	}

}
