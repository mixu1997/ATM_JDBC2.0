package run;

import tool.AbstractView;
import tool.RequestMap;

/**
 * 
 * @author mx
 *������
 */
public class Atm {

	public static void main(String[] args) {
		
		 @SuppressWarnings("rawtypes")
		RequestMap<?, ?> requestMap = new RequestMap();
		 
		 	//��ת��ѡ���¼����
	        requestMap.setDispatherPath("Login");


	        while (true) { 

	            AbstractView av = requestMap.forward();
	            av.view(requestMap);
	        }

	}

}
