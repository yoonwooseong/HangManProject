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

import CheckScore.CheckScoreFrame;
import CheckScore.UserScoreInfo;

public class PlayEnd {
	WhatTime wt;
	public void playEnd(int endTimimg, WhatTime wt, UserScoreInfo usInfo) {

		Frame playEndFrame = new Frame();
		playEndFrame.setLayout(null);
		playEndFrame.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);

		this.wt = wt;
		int time = wt.getCount();
		
		String whatSecond = "";
		JLabel count = new JLabel(whatSecond);//�����忡�� �� �ҷ�����		
		count.setVisible(true);
		count.setBounds(0, 30, 400, 50);
		count.setHorizontalAlignment(JLabel.CENTER);//��Ʈ �������
		count.setFont(font);
		
		String strSecond = "" + (float)time/10 + "��!!";
		Font fonttimecount = new Font("", Font.BOLD, 40);

		JLabel timecount = new JLabel(strSecond);//�����忡�� �� �ҷ�����
		timecount.setFont(fonttimecount);
		timecount.setVisible(true);
		timecount.setBounds(0, 100, 400, 100);
		timecount.setHorizontalAlignment(JLabel.CENTER);//��Ʈ �������
		
		
		//���� ���� �� ���ڿ�
		if(endTimimg == 1) {  
			
			ImageIcon successImg = new ImageIcon("success_color.jpg");
			JLabel endSuccess = new JLabel(successImg);
			endSuccess.setBounds(0, 200, 400, 150);
			playEndFrame.add(endSuccess);
			
		}

		//���� ���� �� ���ڿ�
		if(endTimimg == 2) {
			
			ImageIcon failImg = new ImageIcon("failed_color.jpg");
			JLabel endFail = new JLabel(failImg);
			endFail.setBounds(0, 200, 400, 150);
			playEndFrame.add(endFail);
			
		}



		Button replay = new Button("�ٽ� �ϱ�");
		replay.setBounds(220, 420, 150, 60);
		replay.setFont(font);
		replay.addActionListener(new ActionListener() {
			GameStartView gvs = new GameStartView();

			@Override
			public void actionPerformed(ActionEvent e) {

				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
				gvs.GameStartView(usInfo);

			}
		});


		Button lank = new Button("�·� ����");
		lank.setBounds(30, 420, 150, 60);
		lank.setFont(font);
		
		//playEndFrame�� �߰�
		playEndFrame.setFont(font);
		playEndFrame.add(count);
		playEndFrame.add(lank);
		playEndFrame.add(replay);
		playEndFrame.setFont(fonttimecount);
        playEndFrame.add(timecount);
		
		playEndFrame.setResizable(false);
		playEndFrame.setVisible(true);

		CheckScoreFrame checkScoreFrame = new CheckScoreFrame();
        
        lank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playEndFrame.dispose();
				checkScoreFrame.scoreFrame(usInfo);
				
				
			}
		});

		//����
		playEndFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
			};
		});  
	}


}
