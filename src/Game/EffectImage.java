package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EffectImage extends Thread{

	JLabel j;
	int num;

	public EffectImage(JLabel j, int num) {
		this.j = j;
		this.num = num;
	}

	@Override
	public void run() {
		String str1 = "";
		String str2 = "";
		switch (num) {
		case 5:
			str1 = "playimg_11.jpg"; //**��鸮�� �̹���1
			str2 = "playimg_12.jpg"; //**��鸮�� �̹���2
			break;
		case 4:
			str1 = "playimg_21.jpg"; //**��鸮�� �̹���1
			str2 = "playimg_22.jpg"; //**��鸮�� �̹���2
			break;
		case 3:
			str1 = "playimg_31.jpg";  //**��鸮�� �̹���1
			str2 = "playimg_32.jpg";  //**��鸮�� �̹���2
			break;
		case 2:
			str1 = "playimg_41.jpg";  //**��鸮�� �̹���1
			str2 = "playimg_42.jpg";  //**��鸮�� �̹���2
			break;
		case 1:
			str1 = "playimg_51.jpg";  //**��鸮�� �̹���1
			str2 = "playimg_52.jpg";  //**��鸮�� �̹���2
			break;

		default:
			break;
		}

		for(int i = 0; i < 3; i++) { //i���� ���� �ְ� �ǰ� ���� �Է��ϸ� ���� 
									 //start�� ������ �̹����� ���ĺ��̹Ƿ� 3���� Ÿ���߾��
			try {

				j.setIcon(new ImageIcon(str1));
				Thread.sleep(100);
				j.setIcon(new ImageIcon(str2));
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
