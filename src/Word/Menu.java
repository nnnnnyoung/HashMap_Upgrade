package Word;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
//		모든 소스의 전역변수는 private 지정합니다.
//		선택1. 영어단어와 한글 설명 1개만 저장하는 단어장
//		선택2. 영어단어와 한글설명과 중요도를 저장하는 단어장
//		선택3
//		1) 단어관리(단어저장, 삭제, 수정, 전체보기)
//		단어저장은 영단어를 저장하고 영단어는 중복되지 않습니다.
//		저장할 내용은 한글의미, 설명, 중요도가 필요합니다. 
//		2) 단어 전체보기에는 맨 처음줄에 등록된 단어의 수가 나오고 단어와 정보가 출력
//		ex) 등록된 단어의 수 10개
//		리스트 출력
//		3) 단어공부하기 기능 
//		랜덤으로 한글의미가 나오며 해당 영어단어를 입력하는 게임입니다.
//		맞으면 점수 10점을 더하고 틀리면 틀린 단어만 따로 저장합니다.
//		게임이 끝나면 틀렸던 단어를 출력합니다.
//
//		메인메뉴 1.단어관리 2.단어공부하기
//
//		선택4)
//		선택3에서 3번항목 추가
//		1) 게임이 끝나면 틀린단어가 몇번 틀렸는지 정보 출력
//		2) 게임이 끝나면 내가 오답으로 작성한 정보도 출력
//		3) 제시된 단어의 최근 3번 정답을 분석하여 2번 이상 틀린경우는 화면에 오답조심이라고 표시한다. 단 3번미만으로 제시된 경우는 오답조심을 표시하지 않는다.

		Word W=new Word();
		Game G=new Game(W);
		WordManager M=new WordManager(W);
		
		Scanner in=new Scanner (System.in);
		
		for(;;) {
			System.out.println("1. 단어관리");
			System.out.println("2. 단어공부하기");
			int no=in.nextInt();
			in.nextLine();
			if(no==1) {
				M.menu();
			}else if(no==2) {
				G.game();
			}

		}


	}
}


