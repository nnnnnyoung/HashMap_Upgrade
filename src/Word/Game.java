package Word;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Word W=null;
	private Scanner in =new Scanner (System.in);
	
	Game(Word w){
		this.W=w;
	}
	
	public void game() {
		
		System.out.println("������ �����մϴ�.");		
		int point=0;
		ArrayList <String> Right=new ArrayList<>();//���� Ʋ�� ������ ����
		ArrayList <String> Wrong=new ArrayList<>();//���� Ʋ�� ������ ���� �ۼ��� ����
		String [] badhits=new String[10]; //��� ������ ���� ���� ���θ� Ȯ���Ͽ� ����
		String [] word=new String[W.getwList().keySet().size()];// ���� ���� �迭
		
		int count=0; //word�� �ε��� ��
		for(String temp:W.getwList().keySet()) {
			word[count]=temp;
			count++; //word�� ���� �ϳ� ����ȴٸ� �ε����� ����
		}
		String []Q=new String[10];
		int []b=new int[10];
		
		for(int i=0; i<10; i++) { //���� 10�� ����
			int num=(int)(Math.random()*W.getwList().keySet().size()); //�������� ����


			Q[i]=word[num];
			System.out.println(W.getwList().get(word[num]).mean); //������ ���ڸ� word�� �ε��������� Ȱ��, �������� ������ ��µȴ�.
		
			int chk=0;
			int wrong=0;
			
			for(int j=i-1; j>=0; j--) {
				if(chk>=3) {
					if(wrong>=2) {
						System.out.println("��������");
						break;
					}
				}else if(Q[j]!=null&&word[num].equals(Q[j])) {
					chk++;
					if(b[j]==1) {
						wrong++;
					}
				}
				
				


			}
			System.out.println("���ܾ �Է��ϼ���");
			String ename=in.nextLine(); //ename�� ���� �Է��� ��
			
			
			if(word[num].equals(ename)) {
				//���� �Է��� ��� ������ ���ܾ ���ٸ� ����
				
				b[i]=0;
				System.out.println("�����Դϴ�.");
				point+=10;
				
			
			}else  {
				System.out.println("�����Դϴ�."); //���� �Է��� ��� ������ ���ܾ �ٸ��ٸ� ����
				
				b[i]=1;//�����̶�� 1����
				Right.add(word[num]);
				Wrong.add(ename);
				
				

			}
			
		}
		System.out.println("��������");
		System.out.println(point+"��");
		if(Wrong.size()==0) {
			System.out.println("��� �������ϴ�!");
		}else {
			System.out.println("�� "+Wrong.size()+"�� Ʋ�Ƚ��ϴ�");
		}
		
		for(int i=0; i<Right.size(); i++) {
			int Wcount=0;
			for(int j=0; j<Right.size(); j++) {
				if(Right.get(i)==Right.get(j)) {
					Wcount++;
				}
			}
			System.out.println("Ʋ���ܾ�: "+Right.get(i)+" �� ��: "+Wrong.get(i)+" Ʋ�� Ƚ��: "+Wcount+"��");
		}
		
	}

}
