package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/***
 * 
 * @author mx 读取文件中的输出语句
 *
 */

public class ReadDisplay {
	
	public static void readDisplay(String filename) {
		
		File file = new File(filename);
		try {
		FileReader reader = new FileReader(file);
		char[] c = new char[1024];
		int count = 0;
		while ((count = reader.read(c)) != -1) {
		String str = new String(c, 0, count);
		System.out.println(str);
		}
		reader.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	
} 
