package tool;

import java.util.Scanner;

/**
 * 在验证普通用户登录时，将输入的账号写成一个方法的返回值，方便后边操作金额的调用
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
 