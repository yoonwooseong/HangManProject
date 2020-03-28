package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LoadHint {
	
	String path = "";
	int levelNum;
	
	File f;
	String[] answers;
	String[] hints = {"", "",""};
	
	//String 배열에 든 답 인텍스 랜덤으로 번호 넣는 숫자
	private int num;
	protected String ans; //답

	public int getLevelNum() {
		return levelNum;
	}

	public String getAns() {
		return ans;
	}
	
	public int getNum() {
		return num;
	}
	
	public LoadHint(int num) {
		this.levelNum = num;
		switch (num) {
		case 1:
			path = "C:\\Web_Project_file\\word\\level1\\";
			break;
		case 2:
			path = "C:\\Web_Project_file\\word\\Level2\\";
			break;
		case 3:
			path = "C:\\Web_Project_file\\word\\Level3\\";
			break;
		default:
			break;
		}
		f = new File(path);
		answers = new String[f.list().length];		//Level별 폴더 안 파일의 갯수만큼 배열 생성
		num = new Random().nextInt(answers.length); //그 배열안의 문제들 중 하나를 랜덤으로 선정하기 위한 숫자 
		ans = "";
		
		loadAnswer();
		loadHints(selectAns());
		
	}
	
	//접근한 디렉토리 안에 있는 하위 요소들의 이름 중 문제로 하나 선정
	public void loadAnswer() {
		
		if( f.isDirectory() ) {

			String[] names = f.list();

			for( int i = 0; i < names.length; i++) {
				answers[i] = names[i].substring(0, names[i].indexOf("."));
			}//for
		}
	}//loadAnswer
	
	//랜덤으로 답 지정
	public String selectAns() {
		ans = answers[num];
		return ans;//랜덤 답 값 리턴
	}
	
	//Hint 지정 
	public void loadHints(String fileName) {
		
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(path+fileName+".txt");
			br = new BufferedReader( fr );

			String res = "";
			while( ( res = br.readLine() ) != null ) {
				String arr[] = res.split("/");
				for(int i = 0; i<arr.length; i++) {
					hints[i] = arr[i];
				}
			}//while

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				
				br.close();
				fr.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//loadHints
	
	public String showHint(int indexNum) {
		String hint = hints[indexNum];
		return hint;
	}
}
