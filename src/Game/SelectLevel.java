package Game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectLevel {

	public void SelectLevelView() {

		Frame selectLevelView = new Frame();
		selectLevelView.setLayout(null);
		selectLevelView.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);

		Button Level1 = new Button(" Level 1 ");
		Level1.setBounds(130, 50, 150, 60);
		Level1.setFont(font);

		Button Level2 = new Button(" Level 2 ");
		Level2.setBounds(130, 250, 150, 60);
		Level2.setFont(font);

		Button Level3 = new Button(" Level 3 ");
		Level3.setBounds(130, 450, 150, 60);
		Level3.setFont(font);

		selectLevelView.add(Level1);
		selectLevelView.add(Level2);
		selectLevelView.add(Level3);

		selectLevelView.setFont(font);
		selectLevelView.setResizable(false);
		selectLevelView.setVisible(true);

		GameFrame gameFrame = new GameFrame();

		Level1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//게임 난이도 별 실행
				selectLevelView.dispose();
				gameFrame.GamePlayView(1);
				//
			}
		});

		Level2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//게임 난이도 별 실행
				selectLevelView.dispose();
				gameFrame.GamePlayView(2);
				//
			}
		});

		Level3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//게임 난이도 별 실행
				selectLevelView.dispose();
				gameFrame.GamePlayView(3);
				//
			}
		});

		//종료
		selectLevelView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
	}
}

