package com.yedam.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferStreamEx1 {
	public static void main(String[] args) {
		// 기본스트림 -> 버퍼스트림
		try {
			FileInputStream fis = new FileInputStream("c:/temp/vscode.exe"); // 기본스트림
			BufferedInputStream bis = new BufferedInputStream(fis); // ▼ // 보조스트림 
			// 기본스트림 생성자(fis)를 보조스트림 매개값(fis)으로 넣어서 쓴다?
			
			FileOutputStream fos = new FileOutputStream("c:/temp/vscopy3.exe");
			BufferedOutputStream bos = new BufferedOutputStream(fos); // ▼

			byte[] buf = new byte[10];
			int read = -1;

			while (true) {
				// ▼ read = fis.read(buf); // 버퍼의 크기만큼 읽어서 채움
				read = bis.read();
				if (read == -1)
					break;
				// ▼ fos.write(buf); // 버퍼의 크기만큼 쓰기
				bos.write(read);
			}
			bos.flush();bos.close();fos.flush();fos.close();
			bis.close();fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료");
	}

}
