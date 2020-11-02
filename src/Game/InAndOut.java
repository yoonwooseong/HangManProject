package Game;

import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import CheckScore.ScoreLoader;
import CheckScore.ScoreWriter;
import CheckScore.UserScoreInfo;


public class InAndOut {
	
	StringBuffer outputString = new StringBuffer(); //플레이어의 입력에 따른 결과로 보여줄 문자열
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
	public InAndOut(LoadHint lh, TextArea hint ,String ans, Frame fPlay, JLabel jl, WhatTime wt) {

		this.hint = hint;
		this.lh = lh;
		this.fPlay = fPlay;
		this.ans=ans;
		this.jl = jl;
		this.wt = wt;
		this.saveAph = new char[ans.length()];
		rightCount = 0;
		wrongCount = 6;
		
		//여기가 처음에 글자수만큼 *을 생성하는 곳이에요
		//StringBuffer로 지정해주었기 때문에 나중에 replace(시작위치, 끝낼위치, 바꿀문자열);
		//을 사용해 *** -> d** 가 가능하게 만들었어욥
		for(int i = 0; i < ans.length(); i++) {
			outputString.append("*");
		}
	}//생성자


	public void check_inputStringRecord( Frame fPlay, String input, String ans){

		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//영 소문자 잘 입력하지 못하면
			JOptionPane.showMessageDialog(fPlay, "영 소문자 한개를 입력해주세요.");

		} else {
			//영 소문자 잘 입력
			//그런데 알파벳이 답에 없다면
			if(ans.indexOf(input.charAt(0)) == -1) {

				System.out.println("틀렸음");
				//약올리기 메세지 출력!!
				JOptionPane.showMessageDialog(fPlay, "땡! 다시 한번 생각해보세요!");
				wrongCount--;

				EffectImage ei = new EffectImage(jl, wrongCount);
				
				switch (wrongCount) {
				case 5:
					ei.start();
					break;
				case 4:
					hint.append(lh.showHint(1)+"\n");
					ei.start();
					break;
				case 3:
					ei.start();
					break;   
				case 2:
					hint.append(lh.showHint(2)+"\n");
					ei.start();
					break;
				case 1:
					ei.start();
					break;
				case 0:
					jl.setIcon(new ImageIcon("case0.jpg"));
					ei.start();
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
						JOptionPane.showMessageDialog(fPlay, "이미 입력한 문자입니다..");
					}
				}
			}
		}

	}//입력값 확인 메서드

	//다맞췄을때와 틀렸을때

	PlayEnd pe= new PlayEnd();

	public void SucAndFail(String ans, UserScoreInfo usInfo) {

		int wincount=0;
		int losecount=0;
		int totalcount=0;
		
		//win, lose, score를 불러오기.
		ScoreLoader loader = new ScoreLoader(usInfo);
		
		//불러온 값들을 get으로 각 변수에 대입.
		wincount = loader.getInfo().getWin();
		losecount = loader.getInfo().getLose();
		totalcount = loader.getInfo().getTotal();
		
		//성공
		if(ans.length() == rightCount) {
			
			//이기면 대입된 변수에 이긴카운트만 1올리고 모든 변수를 UserScoreInfo변수에 set시켜줌(writer로 저장하기 위해)
			usInfo.setWin(++wincount);
			usInfo.setLose(losecount);
			
			//난이도 별 가중치 주어 총 점수 부여
			switch (lh.getLevelNum()) {
			case 1:
				totalcount += 1;
				break;
			case 2:
				totalcount += 2;
				break;
			case 3:
				totalcount += 3;
				break;
			default:
				break;
			}
			usInfo.setTotal(totalcount);
			
			//set한 변수를 마지막에 저장!!
			new ScoreWriter(usInfo);
			System.out.println("성공!!");
			
			GameFrame.gameplayframe.dispose();
			pe.playEnd(SUCCESS, wt, usInfo);
		}

		//실패
		if(wrongCount == 0) {
			
			//같은 원리입니다!!
			usInfo.setWin(wincount);
			usInfo.setLose(++losecount);
			usInfo.setTotal(totalcount);
			new ScoreWriter(usInfo);
			
			System.out.println("탈ㄹㄹㄹㄹㄹㄹㄹㄹ락");
			//GameFrame.gameplayframe.dispose();
			pe.playEnd(WRONG, wt, usInfo);
		}
	}


}
