package Game;
import StartPage.*;
import UserIdCreate.*;
import UserLogin.*;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameStartView {

	public void GameStartView() {
	      
	      Frame gameStartFrame = new Frame();
	      gameStartFrame.setLayout(null);
	      gameStartFrame.setBounds(700, 200, 400, 600);
	      Font font = new Font("", Font.BOLD, 20);
	      
	      ImageIcon mainimg = new ImageIcon("hangmain.jpg");
	       JLabel j1 = new JLabel(mainimg);
	       j1.setBounds(130, 60, 258, 195);
	      
	      Button start = new Button("게임 시작");
	      start.setBounds(130, 350, 150, 60);
	      start.setFont(font);
	      
	      gameStartFrame.add(start);
	      gameStartFrame.add(j1);
	      gameStartFrame.setFont(font);
	      gameStartFrame.setResizable(false);
	      gameStartFrame.setVisible(true);
	      
	      //GameFrame gameFrame = new GameFrame();
	      SelectLevel sl = new SelectLevel();
	      start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//게임 실행
				gameStartFrame.dispose();
				//gameFrame.GamePlayView();
				sl.SelectLevelView();
			}
		});
	      
	      //종료
	      gameStartFrame.addWindowListener(new WindowAdapter() {
	        	   public void windowClosing(WindowEvent e) {
	 	              System.exit(0);
	 	           };
			});
	   }

	
}
