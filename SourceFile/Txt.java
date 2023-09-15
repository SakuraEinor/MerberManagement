package index;

import java.io.*;

public class Txt {
	
	//new
	public static void newTxt(String name/*name*/) {
		try {
			BufferedWriter newTxt = new BufferedWriter(new FileWriter(name+".txt"));
			newTxt.write("\t\t<<"+name+"...\n");
			newTxt.close();
		} catch (IOException e) {
			System.out.println("exception occoured "+e);
		}
	}
	
	//add something
	public static void add(String name,String content/*content*/) {
		try {
			BufferedWriter addTxt = new BufferedWriter(new FileWriter(name,true));
			addTxt.write(content);
			addTxt.close();
		} catch (IOException e) {
			System.out.println("exception occoured "+e);
		}
	}
	
	//output all
	public static void out(String name/*name*/) {
		try {
			BufferedReader readTxt = new BufferedReader(new FileReader(name+".txt"));
			String str;
			while((str=readTxt.readLine()) != null){
				System.out.println(str);
			}
			readTxt.close();
		} catch (IOException e) {
			System.out.println("exception occoured "+e);
		}
	}
	
	//read text by line
	public static String read(String name, int line/*details in appointed line*/) {
		String s = null;
        try {
        	FileReader in = new FileReader(name+".txt");
        	LineNumberReader reader = new LineNumberReader(in);	
        	if (line <= 0) {
        		System.exit(0);
        	}
        	int lines = 0;
        	while (line != lines) {
        		lines++;
        		s = reader.readLine();
        	}
        	reader.close();
        	in.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return s;
	}
	
}
