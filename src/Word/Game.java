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
		String [] word=new String[W.getwList().keySet().size()];// ���� ���� �迭
		
		int count=0; //word�� �ε��� ��
		for(String temp:W.getwList().keySet()) {
			word[count]=temp;
			count++; //word�� ���� �ϳ� ����ȴٸ� �ε����� ����
		}
		String []Q =new String[10]; //���� ���� �ܾ� �����ϴ� �迭
		int [] A =new int[10]; // ���俩�θ� �����ϴ� �迭
		
		for(int i=0; i<10; i++) { //���� 10�� ����
			int num=(int)(Math.random()*W.getwList().keySet().size()); //�������� ����

			Q[i]=word[num];
			
			int Star1=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			int Star2=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			
			while(Star2==Star1) {
				Star2=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			}

		//	System.out.println(W.getwList().get(word[num]).mean); //������ ���ڸ� word�� �ε��������� Ȱ��, �������� ������ ��µȴ�.
			
			for(int j=0; j<W.getwList().get(word[num]).mean.length(); j++) {
				if(j==Star1 || j==Star2) {
					System.out.print("*");
				}else if (j!=Star1 && j!=Star2) {
					System.out.print(W.getwList().get(word[num]).mean.charAt(j));
				}

			}
			System.out.println();
			int chk=0; //�����ܾ ��� ���Դ��� üũ
			int wrong=0; //�� �ܾ Ʋ�� Ƚ�� üũ
			
			for(int j=i-1; j>=0; j--) {
				if(chk==3) { //�����ܾ 3�� ��������
					if(wrong>=2) {// �� �� 2���̻� Ʋ�ȴٸ�
						System.out.println("��������"); //�������� ��� �� 
						break; //����
					}
				}else if(Q[j]!=null&&word[num].equals(Q[j])) {
					//���� ���õ� �ܾ�� ���� �ܾ �������� �ִٸ� chk 1�÷���
					chk++;
					if(A[j]==1) { //�� �� Ʋ�Ⱦ��ٸ� wrong 1�÷���
						wrong++;
					}
				}
			}
			System.out.println("���ܾ �Է��ϼ���");
			String ename=in.nextLine(); //ename�� ���� �Է��� ��
			
			
			if(word[num].equals(ename)) {
				//���� �Է��� ��� ������ ���ܾ ���ٸ� ����
				
				A[i]=0;//�����̶�� 0����
				System.out.println("�����Դϴ�.");
				point+=10; //����Ʈ 10�� �÷���
							
			}else  {
				System.out.println("�����Դϴ�."); //���� �Է��� ��� ������ ���ܾ �ٸ��ٸ� ����
				
				A[i]=1;//�����̶�� 1����
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
			int Wcount=0; //�ܾ�� Ʋ�� Ƚ��
			for(int j=0; j<Right.size(); j++) {
				if(Right.get(i)==Right.get(j)) {
					Wcount++;
				}
			}
			System.out.println("Ʋ���ܾ�: "+Right.get(i)+" �� ��: "+Wrong.get(i)+" Ʋ�� Ƚ��: "+Wcount+"��");
		}
		
	}

}
