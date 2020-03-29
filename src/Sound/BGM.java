package Sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BGM extends Thread{
	@Override
	public void run() {
		File f = new File("C:\\Web_Project_file\\BGM\\Late_Night_Drive.wav\\");
		Clip clip;
		try {
			clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SwingUtilities.invokeLater(() -> {

		});
	}
}
