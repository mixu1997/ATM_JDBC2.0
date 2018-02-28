package tool;

import java.io.IOException;
import java.util.HashMap;

public class RequestMap<K,V> extends HashMap<K,V>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dispatherPath;

    public void setDispatherPath(String dispatherPath) {
        this.dispatherPath = dispatherPath;
    }

    public AbstractView forward() { 

        AbstractView av = null;

        try {
            av = (AbstractView) CommonUtils.reflectInstanceFromProp(dispatherPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return av;
    }
}