package index;

import java.io.IOException;

public class Stop {
	
	//any key
	public static void key() {
		System.out.println("\n\tAny key to continue>>>");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//time
	public static void time(int t) {
		try{
			Thread.sleep(t*1000);
		} catch (Exception e) {
			
		}
	}
	
}
