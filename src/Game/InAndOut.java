package Game;

import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class InandOut {
	
	 StringBuffer outputString = new StringBuffer(); // �÷��̾��� �Է¿� ���� ����� ������ ���ڿ�
	   String playerInputString;
	   
	   int rightCount;
	   int wrongCount;
	   
	   final int SUCCESS=1;
	   final int WRONG=2;

	   TextArea hint;
	   LoadHint lh;
	   Frame fPlay;
	   String ans;
	   JLabel jl;
	   
	   public int getWrongCount() {
	      return wrongCount;
	   }
	   
	   //������
	   public InandOut(LoadHint lh, TextArea hint ,String ans, Frame fPlay, JLabel jl) {

	      
	      this.hint = hint;
	      this.lh = lh;
	      this.fPlay = fPlay;
	      this.ans=ans;
	      this.jl = jl;
	      
	      rightCount = 0;
	      wrongCount = 6;
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
	            wrongCount--;
	            
	            switch (wrongCount) {
	            case 5:
	               jl.setIcon(new ImageIcon("case4.jpg"));
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
	   
	   PlayEnd pe= new PlayEnd();
	   
	   public void SucAndFail(String ans) {
	      //����
	      if(ans.length() == rightCount) {
	    	 
	         System.out.println("����!!");
	         GameFrame.gameplayframe.dispose();
	         pe.playEnd(SUCCESS);
	      }
	      
	      //����
	      if(wrongCount == 0) {
	         System.out.println("Ż������������������");
	         //GameFrame.gameplayframe.dispose();
	         pe.playEnd(WRONG);
	      }
	   }

	   
}
