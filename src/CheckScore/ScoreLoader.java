package CheckScore;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;

import UserIdCreate.IdInfo_Path;

public class ScoreLoader{

	private UserScoreInfo usInfo;

	public UserScoreInfo getInfo(){
		return usInfo;
	}

	public ScoreLoader(UserScoreInfo usInfo) {

		this.usInfo = usInfo; 

		String path = IdInfo_Path.SCOREPATH+usInfo.getId()+
				"\\"+usInfo.getId()+"score.txt";

		File read = new File (path);

		FileInputStream fis= null;
		ObjectInputStream ois = null;

		if(read.exists()) {

			try {

				fis=new FileInputStream(path);
				ois = new ObjectInputStream(fis);

				this.usInfo=(UserScoreInfo)ois.readObject();

				System.out.println("로드 성공");

			} catch (Exception e) {
				// TODO: handle exception

			} finally {
				try {

					ois.close();
					fis.close();

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
