package index;

import java.util.Scanner;

public class Studentin {
	
	//global
	static int N = 50, Class = 4;//number of student and classes
	static String Txtname = "Students";//text's name
	static String[] name = new String[N];
	static String[] num = new String[N];
	static double[][] score = new double[N][Class];
	static Scanner sc = new Scanner(System.in);
		
	//total score
	static double sum(int i) {
		int j;
		double sum = 0;
		for (j=0; j<Class; j++)
			sum += score[i][j];
		return sum;
	}
	
	//average
	static double ave(int i) {
		double ave = sum(i) / Class;
		return ave;
	}
	
	//output one
	static void P(int i) {
		System.out.printf("\n\t--\t姓名\t\t%s\n",name[i]);
		System.out.printf("\t--\t学号\t\t%s\n",num[i]);
		for(int j=0;j<Class;j++) {
			System.out.printf("\t--\t科目%d成绩\t%.2f\n",j+1,score[i][j]);
		}
		System.out.printf("\t--\t平均分\t\t%.2f\n",ave(i));
		System.out.printf("\t--\t总分\t\t%.2f\n",sum(i));
	}
	
	//output all
	static void PA() {
		System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
		System.out.printf("\t||\0\0\0\0姓名\t\0\0\0学号\t");
		for (int i=0; i<Class; i++)
			System.out.printf("\t科目%d",i+1);
		System.out.print("\t平均分\t总分\n");
		System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
		for (int i=0; i<N; i++) {
			if (num[i] == null) continue;
			else {
				System.out.printf("\t||%6s",name[i]);
				System.out.printf("%16s",num[i]);
				for (int j=0; j<Class; j++) {
					System.out.printf("\t%.2f",score[i][j]);
				}
				System.out.printf("\t%.2f",ave(i));
				System.out.printf("\t%.2f\n",sum(i));
				System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
			}
		}
	}
	
	//find
	static void find() {
		int flag = 1;
		String[] re = new String[1];
		System.out.printf("\t输入学生姓名或学号\n");
		re[0] = sc.next();
		for (int i=0; i<N; i++) {
			if (num[i] == null) continue;
			else {
				if (num[i].equals(re[0]) || name[i].equals(re[0])) {
					P(i);
					flag = 0;
					break;
				}
			}
		}
		if (flag == 1) System.out.printf("\n\t!!未找到该学生!!\n");
		Stop.key();
	}
	
	//duplicate check
	static int chong(int i) {
		int j, k, flag=1;
		for (j=0; j<N; j++) {
			if (num[i] != null) {
				if (num[i].equals(num[j]) && i!=j) {
					System.out.printf("\n\t学号重复，请检查:\n");
					System.out.printf("\t姓名\t%s\n",name[j]);
					System.out.printf("\t学号\t%s\n",num[j]);
					for (k=0; k<Class; k++) {
						System.out.printf("   科目%d成绩\t%.2f\n",j+1,score[j][k]);
					}
					System.out.printf("\n\t1.删除原数据\n");
					System.out.printf("\t2.取消本次输入\n");
					if (sc.next().charAt(0) == '1') {
						num[j] = null;
					}
					else {num[i] = null;flag=0;break;}
				}
			}
			else continue;
		}
		return flag;
	}
	
	//add
	static void add() {
		for (int i=0; i<N; i++) {
			if (num[i] == null) {
				System.out.printf("\n（%d）姓名\t",i+1);
				name[i] = sc.next();
				System.out.printf("\n");
				System.out.printf("\0\0\0\0\0学号\t");
				num[i] = sc.next();
				if(chong(i)==1) {
					for (int j=0; j<Class; j++) {
						System.out.printf("\n\0\0\0科目%d成绩\t",j+1);
						score[i][j] = sc.nextDouble();
					}
					System.out.println("");
				}
				System.out.printf("\t输入“0”退出，“1”以继续 =v=\n");
				if (sc.next().charAt(0) == '0') {break;}
			}
			if (i == N-1) {
				System.out.printf("\t学生数量上限\n");
				Stop.key();
			}
		}
	}
	
	//delete
	static void del() {
		int i;
		String[] re = new String[1];
		System.out.printf("\n\t\0输入删除学生姓名或学号\n");
		System.out.printf("\t（重名请输入学号精确删除）\n\t");	
		re[0] = sc.next();
		for (i=0; i<N; i++) {
			if (num[i] != null) {
				if(num[i].equals(re[0]) || name[i].equals(re[0])) {
					num[i] = null;
					System.out.printf("\n\t已删除该学生\n");
					break;
				}
			}
			if (i==N-1) System.out.printf("\n\t!!未找到该生资料!!\n");
		}
		Stop.key();
	}
	
	//modifying information
	static void change() {
		int i, j, flag = 1;
		String[] re = new String[1];
		System.out.printf("\t请输入修改学生姓名或学号\n");
		re[0] = sc.next();
		for (i=0; i<N; i++) {
			if (num[i] != null) {
				if(num[i].equals(re[0]) || name[i].equals(re[0])) {
					System.out.printf("（%d）	姓名	",i+1);
					name[i] = sc.next();
					System.out.printf("\n");
					System.out.printf("	学号	");
					num[i] = sc.next();
					System.out.printf("\n");
					for(j=0;j<Class;j++) {
						System.out.printf("   科目%d成绩	",j+1);
						score[i][j] = sc.nextDouble();
						System.out.printf("\n");
					}
					flag = 0;
					break;
				}
			}
			if(i == N-1 && flag == 1) 
				System.out.printf("	!!未找到该学生!!\n");
		}
		Stop.key();
	}
	
	//student's number
	static void counting() {
		int i, n=0;
		for(i=0; i<N; i++) {
			if(num[i] != null)
				n++;
		}
		System.out.printf("\n\t总共 %d 名学生\n",n);
		Stop.key();
	}
	
	//sort by grade
	static void rank1() {
		int i, j, k;
		String[] cha = new String[1];double[][] chan = new double[1][4];
		for (i=0; i<N; i++) {
			for (j=i+1; j<N; j++) {
				if(num[i] != null && sum(i)<sum(j)) {
					cha[0] = name[i]; name[i] = name[j]; name[j] = cha[0];
					cha[0] = num[i]; num[i] = num[j]; num[j] = cha[0];
					for(k=0;k<Class;k++) {
						chan[0][k] = score[i][k]; score[i][k] = score[j][k]; score[j][k] = chan[0][k];
					}
				}
			}
		}
		Studentin.PA();
		Stop.key();
	}
	
	//sort by number
	static void rank2() {
		int i, j, k;
		String[] cha = new String[1];
		double[][] chan = new double[1][Class];
		for(i=0;i<N;i++) {
			for(j=i+1;j<N;j++) {
				if(num[i] != null && num[j] != null && num[i].compareTo(num[j])>0) {
					cha[0] = name[i]; name[i] = name[j]; name[j] = cha[0];
					cha[0] = num[i]; num[i] = num[j]; num[j] = cha[0];
					for(k=0;k<Class;k++) {
						chan[0][k] = score[i][k]; score[i][k] = score[j][k]; score[j][k] = chan[0][k];
					}
				}
			}
		}
	}
	
	//fractional line
	static void Ps(double s) {
		int i, j;
		Studentin.rank2();
		System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
		System.out.printf("\t||\0\0\0\0姓名\t\0\0\0学号\t");
		for (i=0; i<Class; i++)
			System.out.printf("\t科目%d",i+1);
		System.out.printf("\t平均分\t总分\n");
		for (i=0; i<N; i++) {
			if(num[i] != null && ave(i) >= s) {
				System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
				System.out.printf("\t||%6s",name[i]);
				System.out.printf("%16s",num[i]);
				for(j=0; j<Class; j++) {
					System.out.printf("\t%.2f",score[i][j]);
				}
				System.out.printf("\t%.2f",ave(i));
				System.out.printf("\t%.2f\n",sum(i));
				System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
			}
		}
		Stop.key();
	}
	
	//generate text
	static void input() {
		Txt.newTxt(Txtname);
		Txt.add(Txtname,"\tformat:\tname:\n\t\tnumber:\n");
		for(int i=0;i<Class;i++) {
			int j = i+1;
			Txt.add(Txtname,"\t\tgrade"+j+":\n");
		}//format
		for (int i=0; i<N; i++) {
			if (num[i] != null) {
				Txt.add(Txtname,"\n"+name[i]+"\n"+num[i]);
				for (int j = 0; j< Class; j++) {
					Txt.add(Txtname,"\n"+score[i][j]);
				}
				Txt.add(Txtname,"\n");
			}
		}
	}
	
	//import text
	static void read() {
		for (int k=0; Txt.read(Txtname,6+Class+k*(Class+3))!=null; k++) {//find date
			for (int i=0; i<N; i++) {//deposited form where there is no information
				if (num[i] == null) {
					name[i] = Txt.read(Txtname,5+Class+k*(Class+3));
					num[i] = Txt.read(Txtname,6+Class+k*(Class+3));
					for (int j=0; j<Class; j++) {
						score[i][j] = Double.valueOf(Txt.read(Txtname,7+Class+j+k*(Class+3)));
					}
					break;
				}
			}
		}
	}
	
	//sub menu
	static void more() {
		char c='*';
		while(c!='0') {
			System.out.printf("\n\t[]----------------------------------------------[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“1”计数学生人数")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“2”按成绩排序")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“3”查找学生信息")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“4”按学号排序")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“5”指定分数线")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","输入“0”返回上级菜单")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]----------------------------------------------[]\n\n");
			c = sc.next().charAt(0);
			switch(c) {
			case'1':counting();break;
			case'2':rank1();break;
			case'3':find();break;
			case'4':rank2();PA();Stop.key();break;
			case'5':rank2();
					System.out.println("\t输入分数线:");
					double s = sc.nextDouble();
					Ps(s);
					break;
			}
		}
	}
	
	//main menu
	static void startmune() {
		Time.out();
		System.out.printf("\n\t[]----------------------------------------------[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-20s","欢迎使用成绩录入系统")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","输入“+”以添加学生信息")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","输入“-”以删除学生信息")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","输入“/”以修改学生信息")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","输入“*”以查看更多功能")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-24s","输入“0”以结束使用")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]----------------------------------------------[]\n");
	}
	
	//main
	static void main() {
		read();
		char c;
		startmune();
		c = sc.next().charAt(0);
		while(true) {
			if(c == '0') break;
			else {
				switch(c) {
				case '+' :add();break;
				case '-' :del();break;
				case '/' :change();break;
				case '*' :more();break;
				}
				startmune();
				c = sc.next().charAt(0);
			}
		}
		System.out.print("Enter 1 to generate text\n");
		if(sc.next().charAt(0) == '1') {
			rank2();
			input();
		}
		System.out.printf("\n\t----Thanks for using----\n\t");
		return;
	}
}