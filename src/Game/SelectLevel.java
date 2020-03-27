package Game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SelectLevel {

	public void SelectLevelView() {

		Frame selectLevelView = new Frame();
		selectLevelView.setLayout(null);
		selectLevelView.setBounds(700, 200, 400, 600);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		ImageIcon viewImg = new ImageIcon("gameStartView.png");
		JLabel jimg = new JLabel(viewImg);
		jimg.setBounds(42, 110, 320, 220);

		JLabel jl = new JLabel("Level을 선택해주세요.");
		jl.setBounds(0, 350, 400, 50);
		jl.setFont(font);
		jl.setHorizontalAlignment(JLabel.CENTER);

		Button Level1 = new Button(" Level 1 ");
		Level1.setBounds(15, 400, 110, 60);
		Level1.setFont(font);

		Button Level2 = new Button(" Level 2 ");
		Level2.setBounds(145, 400, 110, 60);
		Level2.setFont(font);

		Button Level3 = new Button(" Level 3 ");
		Level3.setBounds(275, 400, 110, 60);
		Level3.setFont(font);

		selectLevelView.add(jimg);
		selectLevelView.add(jl);
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

