package tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ȡʱ��
 * @author mx
 *
 */
public class AcquisitionTime {
	
	public String time() {
		
		Date date=new Date();
		SimpleDateFormat sp=new SimpleDateFormat("yyyyMMddHHmmss");
		String str=sp.format(date);
		
		//����ʱ��
		return str;
	}
}
 