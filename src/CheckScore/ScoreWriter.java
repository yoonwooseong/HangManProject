package CheckScore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import UserIdCreate.IdInfo_Path;

public class ScoreWriter {
	//들어가기는 들어가는데 파일이 다 깨져서 들어감
	
	//PlayEnd 클래스 승률 확인 action listener에 선언
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
			
			System.out.print("승률저장\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("승률저장실패");
			
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
