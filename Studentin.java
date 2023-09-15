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
		System.out.printf("\n\t--\t����\t\t%s\n",name[i]);
		System.out.printf("\t--\tѧ��\t\t%s\n",num[i]);
		for(int j=0;j<Class;j++) {
			System.out.printf("\t--\t��Ŀ%d�ɼ�\t%.2f\n",j+1,score[i][j]);
		}
		System.out.printf("\t--\tƽ����\t\t%.2f\n",ave(i));
		System.out.printf("\t--\t�ܷ�\t\t%.2f\n",sum(i));
	}
	
	//output all
	static void PA() {
		System.out.printf("\t++--------------------------------------------------------------------------------++]]\n");
		System.out.printf("\t||\0\0\0\0����\t\0\0\0ѧ��\t");
		for (int i=0; i<Class; i++)
			System.out.printf("\t��Ŀ%d",i+1);
		System.out.print("\tƽ����\t�ܷ�\n");
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
		System.out.printf("\t����ѧ��������ѧ��\n");
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
		if (flag == 1) System.out.printf("\n\t!!δ�ҵ���ѧ��!!\n");
		Stop.key();
	}
	
	//duplicate check
	static int chong(int i) {
		int j, k, flag=1;
		for (j=0; j<N; j++) {
			if (num[i] != null) {
				if (num[i].equals(num[j]) && i!=j) {
					System.out.printf("\n\tѧ���ظ�������:\n");
					System.out.printf("\t����\t%s\n",name[j]);
					System.out.printf("\tѧ��\t%s\n",num[j]);
					for (k=0; k<Class; k++) {
						System.out.printf("   ��Ŀ%d�ɼ�\t%.2f\n",j+1,score[j][k]);
					}
					System.out.printf("\n\t1.ɾ��ԭ����\n");
					System.out.printf("\t2.ȡ����������\n");
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
				System.out.printf("\n��%d������\t",i+1);
				name[i] = sc.next();
				System.out.printf("\n");
				System.out.printf("\0\0\0\0\0ѧ��\t");
				num[i] = sc.next();
				if(chong(i)==1) {
					for (int j=0; j<Class; j++) {
						System.out.printf("\n\0\0\0��Ŀ%d�ɼ�\t",j+1);
						score[i][j] = sc.nextDouble();
					}
					System.out.println("");
				}
				System.out.printf("\t���롰0���˳�����1���Լ��� =v=\n");
				if (sc.next().charAt(0) == '0') {break;}
			}
			if (i == N-1) {
				System.out.printf("\tѧ����������\n");
				Stop.key();
			}
		}
	}
	
	//delete
	static void del() {
		int i;
		String[] re = new String[1];
		System.out.printf("\n\t\0����ɾ��ѧ��������ѧ��\n");
		System.out.printf("\t������������ѧ�ž�ȷɾ����\n\t");	
		re[0] = sc.next();
		for (i=0; i<N; i++) {
			if (num[i] != null) {
				if(num[i].equals(re[0]) || name[i].equals(re[0])) {
					num[i] = null;
					System.out.printf("\n\t��ɾ����ѧ��\n");
					break;
				}
			}
			if (i==N-1) System.out.printf("\n\t!!δ�ҵ���������!!\n");
		}
		Stop.key();
	}
	
	//modifying information
	static void change() {
		int i, j, flag = 1;
		String[] re = new String[1];
		System.out.printf("\t�������޸�ѧ��������ѧ��\n");
		re[0] = sc.next();
		for (i=0; i<N; i++) {
			if (num[i] != null) {
				if(num[i].equals(re[0]) || name[i].equals(re[0])) {
					System.out.printf("��%d��	����	",i+1);
					name[i] = sc.next();
					System.out.printf("\n");
					System.out.printf("	ѧ��	");
					num[i] = sc.next();
					System.out.printf("\n");
					for(j=0;j<Class;j++) {
						System.out.printf("   ��Ŀ%d�ɼ�	",j+1);
						score[i][j] = sc.nextDouble();
						System.out.printf("\n");
					}
					flag = 0;
					break;
				}
			}
			if(i == N-1 && flag == 1) 
				System.out.printf("	!!δ�ҵ���ѧ��!!\n");
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
		System.out.printf("\n\t�ܹ� %d ��ѧ��\n",n);
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
		System.out.printf("\t||\0\0\0\0����\t\0\0\0ѧ��\t");
		for (i=0; i<Class; i++)
			System.out.printf("\t��Ŀ%d",i+1);
		System.out.printf("\tƽ����\t�ܷ�\n");
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
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰1������ѧ������")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰2�����ɼ�����")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰3������ѧ����Ϣ")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰4����ѧ������")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰5��ָ��������")+"\t[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]\t\t"+String.format("%-24s","���롰0�������ϼ��˵�")+"[]\n");
			System.out.printf("\t[]\t\t\t\t\t\t[]\n");
			System.out.printf("\t[]----------------------------------------------[]\n\n");
			c = sc.next().charAt(0);
			switch(c) {
			case'1':counting();break;
			case'2':rank1();break;
			case'3':find();break;
			case'4':rank2();PA();Stop.key();break;
			case'5':rank2();
					System.out.println("\t���������:");
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
		System.out.printf("\t[]\t\t"+String.format("%-20s","��ӭʹ�óɼ�¼��ϵͳ")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","���롰+�������ѧ����Ϣ")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","���롰-����ɾ��ѧ����Ϣ")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","���롰/�����޸�ѧ����Ϣ")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-22s","���롰*���Բ鿴���๦��")+"\t[]\n");
		System.out.printf("\t[]\t\t\t\t\t\t[]\n");
		System.out.printf("\t[]\t\t"+String.format("%-24s","���롰0���Խ���ʹ��")+"\t[]\n");
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