package view;

import database.Operation;
import tool.AbstractView;
import tool.EnterAccount;
import tool.RequestMap;
/**
 * 
 * @author mx  �û���ѯ
 *
 */
public class User_Query extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		
		//��ȡ��¼ʱ���˻�
		String account=EnterAccount.getAccount();
		
		Operation op=new Operation();
		op.user_judge(account);
		request.setDispatherPath("Menu_User");
	}

}
