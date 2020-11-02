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
	
	StringBuffer outputString = new StringBuffer(); //�÷��̾��� �Է¿� ���� ����� ������ ���ڿ�
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

	//������
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
		
		//���Ⱑ ó���� ���ڼ���ŭ *�� �����ϴ� ���̿���
		//StringBuffer�� �������־��� ������ ���߿� replace(������ġ, ������ġ, �ٲܹ��ڿ�);
		//�� ����� *** -> d** �� �����ϰ� ��������
		for(int i = 0; i < ans.length(); i++) {
			outputString.append("*");
		}
	}//������


	public void check_inputStringRecord( Frame fPlay, String input, String ans){

		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//�� �ҹ��� �� �Է����� ���ϸ�
			JOptionPane.showMessageDialog(fPlay, "�� �ҹ��� �Ѱ��� �Է����ּ���.");

		} else {
			//�� �ҹ��� �� �Է�
			//�׷��� ���ĺ��� �信 ���ٸ�
			if(ans.indexOf(input.charAt(0)) == -1) {

				System.out.println("Ʋ����");
				//��ø��� �޼��� ���!!
				JOptionPane.showMessageDialog(fPlay, "��! �ٽ� �ѹ� �����غ�����!");
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
						JOptionPane.showMessageDialog(fPlay, "�̹� �Է��� �����Դϴ�..");
					}
				}
			}
		}

	}//�Է°� Ȯ�� �޼���

	//�ٸ��������� Ʋ������

	PlayEnd pe= new PlayEnd();

	public void SucAndFail(String ans, UserScoreInfo usInfo) {

		int wincount=0;
		int losecount=0;
		int totalcount=0;
		
		//win, lose, score�� �ҷ�����.
		ScoreLoader loader = new ScoreLoader(usInfo);
		
		//�ҷ��� ������ get���� �� ������ ����.
		wincount = loader.getInfo().getWin();
		losecount = loader.getInfo().getLose();
		totalcount = loader.getInfo().getTotal();
		
		//����
		if(ans.length() == rightCount) {
			
			//�̱�� ���Ե� ������ �̱�ī��Ʈ�� 1�ø��� ��� ������ UserScoreInfo������ set������(writer�� �����ϱ� ����)
			usInfo.setWin(++wincount);
			usInfo.setLose(losecount);
			
			//���̵� �� ����ġ �־� �� ���� �ο�
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
			
			//set�� ������ �������� ����!!
			new ScoreWriter(usInfo);
			System.out.println("����!!");
			
			GameFrame.gameplayframe.dispose();
			pe.playEnd(SUCCESS, wt, usInfo);
		}

		//����
		if(wrongCount == 0) {
			
			//���� �����Դϴ�!!
			usInfo.setWin(wincount);
			usInfo.setLose(++losecount);
			usInfo.setTotal(totalcount);
			new ScoreWriter(usInfo);
			
			System.out.println("Ż������������������");
			//GameFrame.gameplayframe.dispose();
			pe.playEnd(WRONG, wt, usInfo);
		}
	}


}
