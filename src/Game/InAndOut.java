package Game;

import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class InandOut {

	StringBuffer outputString = new StringBuffer(); // �÷��̾��� �Է¿� ���� ����� ������ ���ڿ�
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
	}//������


	public void check_inputStringRecord( Frame fPlay, String input, String ans){
		//**
		EffectImage ei = new EffectImage(jl);
		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//�� �ҹ��� �� �Է����� ���ϸ�
			JOptionPane.showMessageDialog(fPlay, "�� �ҹ��� �Ѱ��� �Է����ּ���.");

		} else {
			//�� �ҹ��� �� �Է�
			//�׷��� ���ĺ��� �信 ���ٸ�
			if(ans.indexOf(input.charAt(0)) == -1) {

				System.out.println("Ʋ����");
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
						JOptionPane.showMessageDialog(fPlay, "�̹� �Է��� ���� �ƴϴ�?");
					}
				}

			}

		}

	}//�Է°� Ȯ�� �޼���

	//�ٸ��������� Ʋ������

	PlayEnd pe= new PlayEnd();

	public void SucAndFail(String ans) {
		//����
		if(ans.length() == rightCount) {

			System.out.println("����!!");
			GameFrame.gameplayframe.dispose();
			pe.playEnd(SUCCESS, wt);
		}

		//����
		if(wrongCount == 0) {
			System.out.println("Ż������������������");
			//GameFrame.gameplayframe.dispose();
			pe.playEnd(WRONG, wt);
		}
	}


}
