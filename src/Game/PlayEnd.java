package Game;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		
		String whatSecond = "몇초 인지??";
		JLabel count = new JLabel(whatSecond);//스레드에서 초 불러오기
		
		count.setVisible(true);
		count.setBounds(0, 30, 400, 50);
		count.setOpaque(true);//배경색
		count.setBackground(Color.WHITE);
		count.setHorizontalAlignment(JLabel.CENTER);//폰트 가운데정렬
		count.setFont(font);
		
		String strSecond = "" + (float)time/10 + "초!!";
		Font fonttimecount = new Font("", Font.BOLD, 30);

		JLabel timecount = new JLabel(strSecond);//스레드에서 초 불러오기
		timecount.setFont(fonttimecount);
		timecount.setVisible(true);
		timecount.setBounds(0, 60, 400, 100);
		timecount.setOpaque(true);//배경색
		timecount.setBackground(Color.WHITE);
		timecount.setHorizontalAlignment(JLabel.CENTER);//폰트 가운데정렬
		
		
		//성공 했을 때 문자열
		if(endTimimg == 1) {  
			
			String success = "축하합니다 성공!";
			JLabel endSuccess = new JLabel(success);          
			endSuccess.setVisible(true);
			endSuccess.setBounds(0, 200, 400, 150);
			endSuccess.setOpaque(true);
			endSuccess.setBackground(Color.yellow);
			endSuccess.setHorizontalAlignment(JLabel.CENTER);
			endSuccess.setFont(font); 
			playEndFrame.add(endSuccess);
			
		}

		//실패 했을 때 문자열
		if(endTimimg == 2) {
			
			String fail = "실패...다시 도전하세요";
			JLabel endFail = new JLabel(fail);
			endFail.setVisible(true);           
			endFail.setBounds(0, 200, 400, 150);
			endFail.setOpaque(true);
			endFail.setBackground(Color.lightGray);
			endFail.setHorizontalAlignment(JLabel.CENTER);
			endFail.setFont(font);
			playEndFrame.add(endFail);
			
		}



		Button replay = new Button("다시 하기");
		replay.setBounds(210, 420, 170, 90);
		replay.addActionListener(new ActionListener() {
			GameStartView gvs = new GameStartView();

			@Override
			public void actionPerformed(ActionEvent e) {

				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
				gvs.GameStartView(usInfo);

			}
		});


		Button lank = new Button("승률 보기");
		lank.setBounds(20, 420, 170, 90);
		
		//playEndFrame에 추가
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

		//종료
		playEndFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
			};
		});  
	}


}
