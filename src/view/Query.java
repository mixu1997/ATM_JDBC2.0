package view;

import java.io.IOException;
import java.util.Scanner;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * ��ѯ��ͨ�������������������û�
 * @author mx
 *
 */
public class Query extends AbstractView{

	@Override
	public void view(RequestMap<?, ?> request) {
		//��ʾ��Ϣ��ѡ��Ҫ��ѯ���û�״̬
				try {
					CommonUtils.printFromProp("N016");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//����ѡ��״̬
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				int param=sc.nextInt();
				Operation op=new Operation();
				op.judge(param);
				
				//���ز˵�
				request.setDispatherPath("Menu_Admin");
		
	}
}
