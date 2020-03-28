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
			str1 = "case41.jpg"; //**흔들리는 이미지1(다리 하나가 잘린..ㅜㅜ)
			str2 = "case42.jpg"; //**흔들리는 이미지2
			break;
		case 4:
			str1 = "case31.jpg"; //**흔들리는 이미지1(다리 두개가 잘린..ㅜㅜ)
			str2 = "case32.jpg"; //**흔들리는 이미지2
			break;
		case 3:
			str1 = "case2.jpg";  //**흔들리는 이미지1(좀만 더 힘내용~)
			str2 = "case2.jpg";  //**흔들리는 이미지2
			break;
		case 2:
			str1 = "case1.jpg";  //**흔들리는 이미지1(고생했어요~)
			str2 = "case1.jpg";  //**흔들리는 이미지2
			break;
		case 1:
			str1 = "case0.jpg";  //**흔들리는 이미지1
			str2 = "case0.jpg";  //**흔들리는 이미지2
			break;

		default:
			break;
		}

		for(int i = 0; i < 3; i++) { //i값을 많이 주게 되고 빨리 입력하면 전에 
									 //start한 쓰레드 이미지가 겹쳐보이므로 3개로 타협했어욥
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
