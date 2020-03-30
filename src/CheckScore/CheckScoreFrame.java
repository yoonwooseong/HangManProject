package CheckScore;
import UserIdCreate.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import Game.GameFrame;


public class CheckScoreFrame {

	public void scoreFrame(UserScoreInfo usInfo){

		ScoreLoader loader = new ScoreLoader(usInfo);

		Frame checkScoreFrame = new Frame("�·� Ȯ��â");
		checkScoreFrame.setLayout(null);
		checkScoreFrame.setBounds(500, 100, 455, 212);
		Font font = new Font("", Font.BOLD, 20);
		checkScoreFrame.setFont(font);

		//�ε� Ŭ���� �ֱ�

		TextArea csTA = new TextArea();
		csTA.setBounds(0, 50, 450, 150);
		csTA.setBackground(Color.LIGHT_GRAY);
		csTA.append("|  UserID  |"+"| PLAYȽ�� |"+"| CLEAR |"+"| FAIL |"+"| SCORE |"+"\n");
		csTA.append("   ");
		csTA.append(loader.getInfo().getId());
		csTA.append("       ");
		csTA.append(""+loader.getInfo().getPlay()+"��");
		csTA.append("          ");
		csTA.append(""+loader.getInfo().getWin()+"��");
		csTA.append("       ");
		csTA.append(""+loader.getInfo().getLose()+"��");
		csTA.append("      ");
		csTA.append("�� "+loader.getInfo().getTotal()+"��");

		Font taFont = new Font("", Font.BOLD, 15);
		csTA.setFont(taFont);
		csTA.setEditable(false);

		checkScoreFrame.add(csTA);
		checkScoreFrame.setVisible(true);

		//����
		checkScoreFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				checkScoreFrame.dispose();

			};
		});  
	}
}
