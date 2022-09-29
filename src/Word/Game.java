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
		String [] badhits=new String[10]; //모든 문제의 정답 오답 여부를 확인하여 저장
		String [] word=new String[W.getwList().keySet().size()];// 문제 저장 배열
		
		int count=0; //word의 인덱스 값
		for(String temp:W.getwList().keySet()) {
			word[count]=temp;
			count++; //word에 값이 하나 저장된다면 인덱스값 증가
		}
		String []Q=new String[10];
		int []b=new int[10];
		
		for(int i=0; i<10; i++) { //게임 10번 진행
			int num=(int)(Math.random()*W.getwList().keySet().size()); //랜덤숫자 저장


			Q[i]=word[num];
			System.out.println(W.getwList().get(word[num]).mean); //랜덤한 숫자를 word의 인덱스값으로 활용, 랜덤으로 문제가 출력된다.
		
			int chk=0;
			int wrong=0;
			
			for(int j=i-1; j>=0; j--) {
				if(chk>=3) {
					if(wrong>=2) {
						System.out.println("오답주의");
						break;
					}
				}else if(Q[j]!=null&&word[num].equals(Q[j])) {
					chk++;
					if(b[j]==1) {
						wrong++;
					}
				}
				
				


			}
			System.out.println("영단어를 입력하세요");
			String ename=in.nextLine(); //ename은 내가 입력한 답
			
			
			if(word[num].equals(ename)) {
				//내가 입력한 답과 문제의 영단어가 같다면 정답
				
				b[i]=0;
				System.out.println("정답입니다.");
				point+=10;
				
			
			}else  {
				System.out.println("오답입니다."); //내가 입력한 답과 문제의 영단어가 다르다면 오답
				
				b[i]=1;//오답이라면 1저장
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
			int Wcount=0;
			for(int j=0; j<Right.size(); j++) {
				if(Right.get(i)==Right.get(j)) {
					Wcount++;
				}
			}
			System.out.println("틀린단어: "+Right.get(i)+" 내 답: "+Wrong.get(i)+" 틀린 횟수: "+Wcount+"번");
		}
		
	}

}
