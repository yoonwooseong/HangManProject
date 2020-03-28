package CheckScore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import UserIdCreate.IdInfo_Path;

public class ScoreWriter {
	//����� ���µ� ������ �� ������ ��
	
	//PlayEnd Ŭ���� �·� Ȯ�� action listener�� ����
	public ScoreWriter(UserScoreInfo usInfo) {
		
		String path = IdInfo_Path.SCOREPATH+usInfo.getId()+
		"\\"+usInfo.getId()+"score.txt";
		
		
		File dir = new File( IdInfo_Path.SCOREPATH+usInfo.getId());
		
		if(!dir.exists()) {
			dir.mkdirs();
			
		}
	
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(usInfo);
			
			System.out.print("�·�����\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�·��������");
			
		} finally {
			
			try {
				
				oos.close();
				fos.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
