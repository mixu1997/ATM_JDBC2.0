package tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间
 * @author mx
 *
 */
public class AcquisitionTime {
	
	public String time() {
		
		Date date=new Date();
		SimpleDateFormat sp=new SimpleDateFormat("yyyyMMddHHmmss");
		String str=sp.format(date);
		
		//返回时间
		return str;
	}
}
 