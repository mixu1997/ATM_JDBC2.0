package tool;

import java.util.Scanner;

/**
 * ����֤��ͨ�û���¼ʱ����������˺�д��һ�������ķ���ֵ�������߲������ĵ���
 * @author mx
 *
 */
public class EnterAccount {
	
	private static String account;
	
	public static String enterAccount() {
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		account=sc.nextLine();
		return account;
		
	}
	public static String getAccount () {
		
		return account;
	}
}
 