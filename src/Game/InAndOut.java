package Game;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class InAndOut {

	StringBuffer outputString = new StringBuffer(); // �÷��̾��� �Է¿� ���� ����� ������ ���ڿ�
	String playerInputString;

	int rightCount;
	int wrongCount;

	public InAndOut(String ans) {

		rightCount = 0;
		wrongCount = 5;//��ȸ
		for(int i = 0; i < ans.length(); i++) {
			outputString.append("*");
		}
	}//������

	public void check_inputStringRecord(Frame fPlay, String input, String ans){

		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//�� �ҹ��� �� �Է����� ���ϸ�
			JOptionPane.showMessageDialog(fPlay, "�� �ҹ��� �Ѱ��� �Է����ּ���.");
			
		} else {
			//�� �ҹ��� �� �Է�
			//�׷��� ���ĺ��� �信 ���ٸ�
			if(ans.indexOf(input.charAt(0)) == -1) {
				wrongCount--;
			}
			
			//���ĺ��� ���� �ִ��� Ȯ��
			for(int i = 0; i < ans.length(); i++) {
				//���ĺ��� �信 �ִٸ�
				if(ans.charAt(i) == input.charAt(0)) {
					outputString.replace(i, i+1, input);
					rightCount++;
				}
			}
		}

	}//�Է°� Ȯ�� �޼���
	
	//�ٸ��������� Ʋ������
	public void SucAndFail(String ans) {
		//����
		if(ans.length() == rightCount) {
			
			System.out.println("����!!");
		}
		//����
		if(wrongCount == 0) {
			
			System.out.println("Ż������������������");
		}
	}
}