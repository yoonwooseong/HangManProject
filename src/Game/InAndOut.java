package Game;

import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class InandOut {

	StringBuffer outputString = new StringBuffer(); // 플레이어의 입력에 따른 결과로 보여줄 문자열
	String playerInputString;
	
	TextArea hint;
	LoadHint lh;
	Frame fPlay;
	String ans;
	JLabel jl;
	WhatTime wt;

	int rightCount;
	int wrongCount;
	
	final int SUCCESS=1;
	final int WRONG=2;
	char[] saveAph;

	
	public int getWrongCount() {
		return wrongCount;
	}

	//생성자
	public InandOut(LoadHint lh, TextArea hint ,String ans, Frame fPlay, JLabel jl, WhatTime wt) {

		this.hint = hint;
		this.lh = lh;
		this.fPlay = fPlay;
		this.ans=ans;
		this.jl = jl;
		this.wt = wt;
		this.saveAph = new char[ans.length()];
		rightCount = 0;
		wrongCount = 6;
		
		for(int i = 0; i < ans.length(); i++) {
			outputString.append("*");
		}
	}//생성자


	public void check_inputStringRecord( Frame fPlay, String input, String ans){
		//**
		EffectImage ei = new EffectImage(jl);
		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//영 소문자 잘 입력하지 못하면
			JOptionPane.showMessageDialog(fPlay, "영 소문자 한개를 입력해주세요.");

		} else {
			//영 소문자 잘 입력
			//그런데 알파벳이 답에 없다면
			if(ans.indexOf(input.charAt(0)) == -1) {

				System.out.println("틀렸음");
				wrongCount--;

				switch (wrongCount) {
				case 5:
					//**
					ei.setDaemon(true);
					ei.start();
					//jl.setIcon(new ImageIcon("case4.jpg"));
					break;
				case 4:
					jl.setIcon(new ImageIcon("case3.jpg"));
					hint.append(lh.showHint(1)+"\n");
					break;
				case 3:
					jl.setIcon(new ImageIcon("case2.jpg"));
					break;   
				case 2:
					jl.setIcon(new ImageIcon("case1.jpg"));
					hint.append(lh.showHint(2)+"\n");
					break;
				case 1:
					jl.setIcon(new ImageIcon("case0_1.jpg"));
					break;
				case 0:
					jl.setIcon(new ImageIcon("case0.jpg"));
					break;
				default:
					break;
				}
			} else {
				
				int count = 0;
				
				for(int i = 0; i < ans.length(); i++) {
					if (ans.charAt(i) == input.charAt(0) && saveAph[i] != input.charAt(0)) {
						saveAph[i] = input.charAt(0);
						outputString.replace(i, i+1, input);
						rightCount++;
					} else if (saveAph[i] == input.charAt(0) && count==0) {
						count++;
						JOptionPane.showMessageDialog(fPlay, "이미 입력한 문자 아니니?");
					}
				}

			}

		}

	}//입력값 확인 메서드

	//다맞췄을때와 틀렸을때

	PlayEnd pe= new PlayEnd();

	public void SucAndFail(String ans) {
		//성공
		if(ans.length() == rightCount) {

			System.out.println("성공!!");
			GameFrame.gameplayframe.dispose();
			pe.playEnd(SUCCESS, wt);
		}

		//실패
		if(wrongCount == 0) {
			System.out.println("탈ㄹㄹㄹㄹㄹㄹㄹㄹ락");
			//GameFrame.gameplayframe.dispose();
			pe.playEnd(WRONG, wt);
		}
	}


}
