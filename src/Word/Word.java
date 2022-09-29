package Word;

import java.util.HashMap;
import java.util.Scanner;


class ValueType {
	String mean;
	String info;
	String level;
}


public class Word {
	private String Word;
	private Scanner in=new Scanner (System.in);
	
	private HashMap <String, ValueType> wList=new HashMap<>();
	
	Word(){
		ValueType v=new ValueType();
		v.info="동사";v.level="중";v.mean="피로해지다";
		wList.put("tire", v);

	}
	
	
	
	
	public void input() {
		System.out.println("추가할 영단어를 입력해주세요");
		this.Word=in.nextLine();
		if(wList.containsKey(Word)) {
			System.out.println("이미 중복된 단어가 있습니다.");
		}else {
			ValueType v=new ValueType();
			System.out.println("뜻을 입력하세요");
			v.mean=in.nextLine();
			System.out.println("설명을 입력하세요");
			v.info=in.nextLine();
			System.out.println("난이도를 입력하세요(상,중,하)");
			v.level=in.nextLine();
			for(;;) {
				if(v.level.equals("상")||v.level.equals("중")||v.level.equals("하")) {
					break;
				}else {
					System.out.println("상,중,하로 입력하세요");
					v.level=in.nextLine();
				}
			}

			wList.put(Word, v);
		}
	}
	
	public void del() {
		System.out.println("삭제할 단어를 입력하세요");
		String delName=in.nextLine();
		if(wList.containsKey(delName)) {
			wList.remove(delName);
		}else {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("삭제완료");
	}
	
	public void modi() {
		System.out.println("수정할 단어를 입력하세요");
		String modiName=in.nextLine();
		if(wList.containsKey(modiName)) {
			System.out.println("무엇을 수정할까요?");
			System.out.println("1. 영단어 수정");
			System.out.println("2. 뜻 수정");
			System.out.println("3. 설명 수정");
			System.out.println("4. 난이도 수정");
			int no=in.nextInt();
			in.nextLine();
			if(no==1) {
				ValueType v=new ValueType();
				v.info=wList.get(modiName).info;
				v.level=wList.get(modiName).level;
				v.mean=wList.get(modiName).mean;
				wList.remove(modiName);
				System.out.println("무엇으로 수정할까요?");
				String newName=in.nextLine();
				wList.put(newName, v);	
			}else if(no==2) {
				System.out.println("무엇으로 수정할까요?");
				wList.get(modiName).mean=in.nextLine();
			}else if(no==3) {
				System.out.println("무엇으로 수정할까요?");
				wList.get(modiName).info=in.nextLine();
			}else if(no==4) {
				System.out.println("무엇으로 수정할까요?");
				wList.get(modiName).level=in.nextLine();
				for(;;) {
					if(wList.get(modiName).level.equals("상")||
						wList.get(modiName).level.equals("중")||
						wList.get(modiName).level.equals("하")) {	
						break;
						}else {
						System.out.println("상,중,하로 입력하세요");
						wList.get(modiName).level=in.nextLine();
						}
				}
			}
			System.out.println("수정완료");
		}else {
			System.out.println("수정할 단어가 없습니다.");
		}
	}
	
	public void prt() {
		System.out.println("등록된 단어의 갯수: "+wList.size()+"개");
		for(String temp: wList.keySet()) {
			System.out.println("영단어: "+temp);
			System.out.println("뜻: "+wList.get(temp).mean);
			System.out.println("설명: "+wList.get(temp).info);
			System.out.println("난이도: "+wList.get(temp).level);
			System.out.println("----------------------------");
		}
	}
	





	public HashMap<String, ValueType> getwList() {
		return wList;
	}




}
