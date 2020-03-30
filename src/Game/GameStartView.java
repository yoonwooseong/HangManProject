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

import CheckScore.CheckScoreFrame;
import CheckScore.UserScoreInfo;

public class GameStartView {

	public void GameStartView(UserScoreInfo usInfo) {

		Frame gameStartFrame = new Frame();
		gameStartFrame.setLayout(null);
		gameStartFrame.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);

		ImageIcon mainimg = new ImageIcon("gameview_img.jpg"); //*이미지 첨부1
		JLabel j1 = new JLabel(mainimg);
		j1.setBounds(42, 100, 320, 220);

		Button start = new Button("게임 시작");
		start.setBounds(125, 350, 150, 60);
		start.setFont(font);

		Button rank = new Button("누적 보기");
		rank.setBounds(125, 450, 150, 60);
		rank.addActionListener(new ActionListener() {

			CheckScoreFrame csFrame = new CheckScoreFrame();

			@Override
			public void actionPerformed(ActionEvent arg0) {

				csFrame.scoreFrame(usInfo);

			}
		});

		gameStartFrame.add(start);
		gameStartFrame.add(j1);
		gameStartFrame.setFont(font);
		gameStartFrame.add(rank);
		gameStartFrame.setResizable(false);
		gameStartFrame.setVisible(true);

		//GameFrame gameFrame = new GameFrame();
		start.addActionListener(new ActionListener() {

			SelectLevel sl = new SelectLevel();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//게임 실행
				gameStartFrame.dispose();
				//gameFrame.GamePlayView();
				sl.SelectLevelView(usInfo);
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
