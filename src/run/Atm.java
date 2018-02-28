package run;

import tool.AbstractView;
import tool.RequestMap;

/**
 * 
 * @author mx
 *运行类
 */
public class Atm {

	public static void main(String[] args) {
		
		 @SuppressWarnings("rawtypes")
		RequestMap<?, ?> requestMap = new RequestMap();
		 
		 	//跳转到选择登录界面
	        requestMap.setDispatherPath("Login");


	        while (true) { 

	            AbstractView av = requestMap.forward();
	            av.view(requestMap);
	        }

	}

}
