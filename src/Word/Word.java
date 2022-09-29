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
		v.info="����";v.level="��";v.mean="�Ƿ�������";
		wList.put("tire", v);

	}
	
	
	
	
	public void input() {
		System.out.println("�߰��� ���ܾ �Է����ּ���");
		this.Word=in.nextLine();
		if(wList.containsKey(Word)) {
			System.out.println("�̹� �ߺ��� �ܾ �ֽ��ϴ�.");
		}else {
			ValueType v=new ValueType();
			System.out.println("���� �Է��ϼ���");
			v.mean=in.nextLine();
			System.out.println("������ �Է��ϼ���");
			v.info=in.nextLine();
			System.out.println("���̵��� �Է��ϼ���(��,��,��)");
			v.level=in.nextLine();
			for(;;) {
				if(v.level.equals("��")||v.level.equals("��")||v.level.equals("��")) {
					break;
				}else {
					System.out.println("��,��,�Ϸ� �Է��ϼ���");
					v.level=in.nextLine();
				}
			}

			wList.put(Word, v);
		}
	}
	
	public void del() {
		System.out.println("������ �ܾ �Է��ϼ���");
		String delName=in.nextLine();
		if(wList.containsKey(delName)) {
			wList.remove(delName);
		}else {
			System.out.println("������ �ܾ �����ϴ�.");
			return;
		}
		System.out.println("�����Ϸ�");
	}
	
	public void modi() {
		System.out.println("������ �ܾ �Է��ϼ���");
		String modiName=in.nextLine();
		if(wList.containsKey(modiName)) {
			System.out.println("������ �����ұ��?");
			System.out.println("1. ���ܾ� ����");
			System.out.println("2. �� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���̵� ����");
			int no=in.nextInt();
			in.nextLine();
			if(no==1) {
				ValueType v=new ValueType();
				v.info=wList.get(modiName).info;
				v.level=wList.get(modiName).level;
				v.mean=wList.get(modiName).mean;
				wList.remove(modiName);
				System.out.println("�������� �����ұ��?");
				String newName=in.nextLine();
				wList.put(newName, v);	
			}else if(no==2) {
				System.out.println("�������� �����ұ��?");
				wList.get(modiName).mean=in.nextLine();
			}else if(no==3) {
				System.out.println("�������� �����ұ��?");
				wList.get(modiName).info=in.nextLine();
			}else if(no==4) {
				System.out.println("�������� �����ұ��?");
				wList.get(modiName).level=in.nextLine();
				for(;;) {
					if(wList.get(modiName).level.equals("��")||
						wList.get(modiName).level.equals("��")||
						wList.get(modiName).level.equals("��")) {	
						break;
						}else {
						System.out.println("��,��,�Ϸ� �Է��ϼ���");
						wList.get(modiName).level=in.nextLine();
						}
				}
			}
			System.out.println("�����Ϸ�");
		}else {
			System.out.println("������ �ܾ �����ϴ�.");
		}
	}
	
	public void prt() {
		System.out.println("��ϵ� �ܾ��� ����: "+wList.size()+"��");
		for(String temp: wList.keySet()) {
			System.out.println("���ܾ�: "+temp);
			System.out.println("��: "+wList.get(temp).mean);
			System.out.println("����: "+wList.get(temp).info);
			System.out.println("���̵�: "+wList.get(temp).level);
			System.out.println("----------------------------");
		}
	}
	





	public HashMap<String, ValueType> getwList() {
		return wList;
	}




}
