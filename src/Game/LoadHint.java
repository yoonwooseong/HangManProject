package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LoadHint {
	
	String path = "";
	
	File f;
	String[] answers = {"", ""};
	String[] hints = {"", "",""};
	
	//String �迭�� �� �� ���ؽ� �������� ��ȣ �ֱ� 
	private int num = new Random().nextInt(answers.length);
	protected String ans = "";

	public String getAns() {
		return ans;
	}
	
	public int getNum() {
		return num;
	}
	
	public LoadHint(int num) {
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
		loadAnswer();
		loadHints(selectAns());
	}
	
	//������ ���丮 �ȿ� �ִ� ���� ��ҵ��� �̸� �� ������ �ϳ� ����
	public void loadAnswer() {
		if( f.isDirectory() ) {

			String[] names = f.list();

			for( int i = 0; i < names.length; i++) {
				answers[i] = names[i].substring(0, names[i].indexOf("."));
			}//for
		}
	}//loadAnswer
	
	//�������� �� ����
	public String selectAns() {
		ans = answers[num];
		return ans;//���� �� �� ����
	}
	
	//Hint ���� 
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
