package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EffectImage extends Thread{
	
	JLabel j;
	
	
	public EffectImage(JLabel j) {
		this.j = j;
	}
	@Override
	public void run() {
		while(true) {
			try {
				j.setIcon(new ImageIcon("case41.jpg"));
				Thread.sleep(100);
				j.setIcon(new ImageIcon("case42.jpg"));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
