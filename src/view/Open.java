package view;
import java.io.IOException;
import java.util.Scanner;

import com.feicuiedu.User;

import database.Operation;
import tool.AbstractView;
import tool.CommonUtils;
import tool.RequestMap;

/**
 * ����
 * @author mx
 *
 */
public class Open extends AbstractView{
	//����
	private int id;
	//����
	private String name;
	//���֤��
	private String idcard;
	//�Ա�
	private String sex;
	//��������
	private String birth;
	//��ַ
	private String site;
	//�˻�
	private String account;
	//����
	private String password;
	//���
	private double balance=0.0;
		
	@Override
	public void view(RequestMap<?, ?> request) {
		@SuppressWarnings("resource")
		Scanner sca=new Scanner(System.in);
		//��������
		Operation op=new Operation();
		this.id=op.key();

		while(true) {//��������
			
			try {
				
				CommonUtils.printFromProp("N003");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.name = sca.next();
			
			if(!name.matches("^.{1,10}$")) {
				
				try {
					
					CommonUtils.printFromProp("N004");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				break;
			}
		}
		
		while (true) {//�������֤��
			
			try {
				CommonUtils.printFromProp("N007");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.idcard = sca.next();
			//15λ��18λ����
			try {
				CommonUtils.printFromProp("N014");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (!idcard.matches("^\\d{15}|\\d{18}$")) {
				
				try {
					
					CommonUtils.printFromProp("N008");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else {
				
				break;
			}
		}
		
		while (true) {//ѡ���Ա�
			
			try {
				
				CommonUtils.printFromProp("N005");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String param = sca.next();
			//����1ʱΪ��
			if (param.equals("1")) {
				
				this.sex = "01";
				break;
			} 
			//����2ʱΪŮ
			else if (param.equals("2")) {
				
				this.sex = "02";
				break;
			} 
			else {
				
				try {
					CommonUtils.printFromProp("N006");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
		while (true) {//�����������
			try {
				CommonUtils.printFromProp("N009");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
																
			this.birth = sca.next();
			try {
				CommonUtils.printFromProp("N013");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!birth.matches("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\-\\s]?((((0?" +"[13578])|(1[02]))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +"|(((0?[469])|(11))[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +"(0?2[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12" +"35679])|([13579][01345789]))[\\-\\-\\s]?((((0?[13578])|(1[02]))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +"[\\-\\-\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\-\\s]?((0?[" +"1-9])|(1[0-9])|(2[0-8]))))))")) {
				
				try {
					CommonUtils.printFromProp("N010");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				break;
			}
		}
		
		while (true) {//�����ַ
			try {
				CommonUtils.printFromProp("N011");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.site = sca.next();
			if (site.length() > 150) {
				try {
					CommonUtils.printFromProp("N012");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.site = sca.next();
			} 
			else {
				break;
			}
		}
		
		//��λ�����
		int param=(int)((Math.random()*9+1)*1000); 
		//�����˺ţ��˺Ÿ�ʽ��BC18 + �Ա�(��01:Ů02)  + �������� + 4λ�����
		this.account = "BC18" + sex + birth + param;
		System.out.println("�����˺��ǣ�"+account);
		
		while (true) {//��������
			try {
				CommonUtils.printFromProp("N001");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String password0= sca.next();
			if (!password0.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")) {
					try {
						CommonUtils.printFromProp("N002");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} 
			else {
				try {
					CommonUtils.printFromProp("N001");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.password= sca.next();
				if(password.equals(password0)) {
					break;
				}
				else {
					try {
						CommonUtils.printFromProp("N002");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		id = op.key();
		User user = new User(id,name,idcard, sex, birth, site,balance, account,password);
		
		try {
			CommonUtils.printFromProp("M001");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ݿ�

		op.interposition(user);
		//���ز˵�
		request.setDispatherPath("Menu_Admin");
		
	}
}