package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamEx1 {
/*
 * 바이트(1byte), char(2byte) => 객체를 처리해주는 보조스트림
 */
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/file4.dat"); // 읽어들이는 용도
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<MemberVO> list = (List<MemberVO>)ois.readObject();
			list.forEach(member -> System.out.println(member));
			
			ois.close();fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("완료");
	}
	
	static void writer1(){
		List<MemberVO> members = new ArrayList<>();	
		members.add (new MemberVO(101, "몽순이", 120));
		members.add (new MemberVO(102, "하랑", 110));
		members.add (new MemberVO(103, "하율", 125));
		members.add (new MemberVO(104, "발가락", 115));
		
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/file4.dat"); // 기본타입을
			ObjectOutputStream oos = new ObjectOutputStream(fos); // 객체로 전환 해주는  serialize(직렬화)
			// serialize(직렬화) -> deserialize(역직렬화)
			oos.writeObject(members);
			
			oos.flush();oos.close();
			fos.flush();fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료");
	}

}
