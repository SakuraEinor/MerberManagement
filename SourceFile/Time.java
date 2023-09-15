package index;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Time {
	
	//time out
	public static String out() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));//print time
		return df.format(new Date());//return time
	}

}