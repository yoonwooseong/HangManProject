package UserIdCreate;

import java.awt.Frame;
import java.awt.TextField;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class CId_CreateWrite  {

	public void infoWrite(IdInfo_Path uid, TextField id,Frame id_createFrame) {

		String path = IdInfo_Path.PATH+id.getText()+"\\"+id.getText() + ".txt";

		File dir1 = new File(IdInfo_Path.PATH);
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		File dir2 = new File(dir1,id.getText());
		if(!dir2.exists()) {
			dir2.mkdirs();
			//}

			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			//int code = 0;
			
			try {

				fos = new FileOutputStream(path);
				bos = new BufferedOutputStream(fos);

				bos.write(id.getText().getBytes());
				System.out.println("정보저장성공");
				JOptionPane.showMessageDialog(id_createFrame, "가입 성공");
				id_createFrame.dispose();

			} catch (Exception e2) {
				// TODO: handle exception
			}finally {
				try {
					bos.close();
					fos.close();

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else {

			JOptionPane.showMessageDialog(id_createFrame, "중복된아이디입니다.");

		}

	}

}
