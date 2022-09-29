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
		
		System.out.println("게임을 시작합니다.");		
		int point=0;
		ArrayList <String> Right=new ArrayList<>();//내가 틀린 문제의 정답
		ArrayList <String> Wrong=new ArrayList<>();//내가 틀린 문제의 내가 작성한 오답
		String [] word=new String[W.getwList().keySet().size()];// 문제 저장 배열
		
		int count=0; //word의 인덱스 값
		for(String temp:W.getwList().keySet()) {
			word[count]=temp;
			count++; //word에 값이 하나 저장된다면 인덱스값 증가
		}
		String []Q =new String[10]; //문제 나온 단어 저장하는 배열
		int [] A =new int[10]; // 정답여부를 저장하는 배열
		
		for(int i=0; i<10; i++) { //게임 10번 진행
			int num=(int)(Math.random()*W.getwList().keySet().size()); //랜덤숫자 저장

			Q[i]=word[num];
			
			int Star1=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			int Star2=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			
			while(Star2==Star1) {
				Star2=(int)(Math.random()*W.getwList().get(word[num]).mean.length());
			}

		//	System.out.println(W.getwList().get(word[num]).mean); //랜덤한 숫자를 word의 인덱스값으로 활용, 랜덤으로 문제가 출력된다.
			
			for(int j=0; j<W.getwList().get(word[num]).mean.length(); j++) {
				if(j==Star1 || j==Star2) {
					System.out.print("*");
				}else if (j!=Star1 && j!=Star2) {
					System.out.print(W.getwList().get(word[num]).mean.charAt(j));
				}

			}
			System.out.println();
			int chk=0; //같은단어가 몇번 나왔는지 체크
			int wrong=0; //그 단어를 틀린 횟수 체크
			
			for(int j=i-1; j>=0; j--) {
				if(chk==3) { //같은단어가 3번 나왔을때
					if(wrong>=2) {// 그 중 2번이상 틀렸다면
						System.out.println("오답주의"); //오답주의 출력 후 
						break; //종료
					}
				}else if(Q[j]!=null&&word[num].equals(Q[j])) {
					//지금 제시된 단어와 같은 단어가 나온적이 있다면 chk 1플러스
					chk++;
					if(A[j]==1) { //그 때 틀렸었다면 wrong 1플러스
						wrong++;
					}
				}
			}
			System.out.println("영단어를 입력하세요");
			String ename=in.nextLine(); //ename은 내가 입력한 답
			
			
			if(word[num].equals(ename)) {
				//내가 입력한 답과 문제의 영단어가 같다면 정답
				
				A[i]=0;//정답이라면 0저장
				System.out.println("정답입니다.");
				point+=10; //포인트 10점 플러스
							
			}else  {
				System.out.println("오답입니다."); //내가 입력한 답과 문제의 영단어가 다르다면 오답
				
				A[i]=1;//오답이라면 1저장
				Right.add(word[num]);
				Wrong.add(ename);

			}
			
		}
		System.out.println("게임종료");
		System.out.println(point+"점");
		if(Wrong.size()==0) { 
			System.out.println("모두 맞혔습니다!");
		}else {
			System.out.println("총 "+Wrong.size()+"개 틀렸습니다");
		}
		
		for(int i=0; i<Right.size(); i++) {
			int Wcount=0; //단어당 틀린 횟수
			for(int j=0; j<Right.size(); j++) {
				if(Right.get(i)==Right.get(j)) {
					Wcount++;
				}
			}
			System.out.println("틀린단어: "+Right.get(i)+" 내 답: "+Wrong.get(i)+" 틀린 횟수: "+Wcount+"번");
		}
		
	}

}
