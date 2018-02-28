package tool;

import java.io.IOException;
import java.util.Properties;
/**
 * 通过反射方法，实现方法之间的调用
 * @author mx
 *
 */
public class CommonUtils {
	
	   public static Object reflectInstanceFromProp(String key) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

	        String className = getValueFromProp(key);
	       // System.out.println(key +">>>"+ className);
	        return reflectInstanceFromClassName(className);
	    }
	   
	   public static Object reflectInstanceFromClassName(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
	        //System.out.println(className);
		   Object instance = Class.forName(className).newInstance();

	        return instance;
	    }
	   
	   public static String getValueFromProp(String key) throws IOException {

	        Properties prop = new Properties();

	        prop.load(CommonUtils.class.getClassLoader().getResourceAsStream("config.properties"));

	        String value = prop.getProperty(key);

	        return value;
	    }
	   
	   public static void printFromProp(String key) throws IOException {
		   //根据键取文本中的语句
	        String value = getValueFromProp(key);

	        System.out.println(value);
	    }
 
}
