package Word;
import java.util.Scanner;
public class WordManager {

	private Scanner in=new Scanner (System.in);
	Word W=null;
	
	WordManager(Word W){
		this.W=W;
	}
	
	public void menu() {
		for(;;) {
			System.out.println("1.단어저장");
			System.out.println("2.단어삭제");
			System.out.println("3.단어수정");
			System.out.println("4.단어전체보기");
			System.out.println("5.이전으로");
			int no=in.nextInt();
			in.nextLine();
			if(no==1) {
				Input();
			}else if(no==2) {
				Del();
			}else if(no==3) {
				Mod();
			}else if(no==4) {
				Prt();
			}else if(no==5) {
				break;
			}
		}
	}	
	public void Input() {
		W.input();
	}
	
	public void Del() {
		W.del();
	}
	
	public void Mod() {
		W.modi();
	}
	public void Prt() {
		W.prt();
	}


	
	

	
	
}
