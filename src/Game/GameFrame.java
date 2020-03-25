package Game;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameFrame {
	public void GamePlayView() {
		Frame fPlay = new Frame();
		fPlay.setLayout(null);
		fPlay.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);

		//ImageIcon playImg = new ImageIcon("playImg1.jpg");
		//JLabel j = new JLabel(playImg);

		//j.setBounds(100, 0, 200, 280);

		//����, ��Ʈ �ҷ�����
		LoadHint lh = new LoadHint();
		String showHint = lh.showHint(0)+"\n"+lh.showHint(1);

		//���� �ڵ�� ��ü �� ����(�̹��� �������� ĭ)
		Panel test = new Panel();
		test.setBackground(Color.BLUE);
		test.setBounds(100, 0, 200, 280);

		//��Ʈ�� �������� ����
		TextArea hint = new TextArea(showHint, 0, 290, TextArea.SCROLLBARS_NONE);
		//hint.setBackground(Color.YELLOW);
		hint.setEditable(false);
		hint.setBounds(0, 290, 600, 150);

		//�Է��� ������ �������� ���� (_)
		InAndOut inAout = new InAndOut(lh.getAns());
		TextArea showAnswer = new TextArea("", 0, 445, TextArea.SCROLLBARS_NONE);
		//***
		showAnswer.setText(inAout.outputString.toString());
		
		//showAnswer.setBackground(Color.GRAY);
		showAnswer.setEditable(false);
		showAnswer.setBounds(0, 445, 600, 90);

		//User���� �Է� ĭ
		Panel answer = new Panel();

		TextField tfUser = new TextField(15);
		Button btn = new Button(" Enter ");

		answer.setBounds(0, 540, 400, 80);
		answer.add(tfUser);
		answer.add(btn);
		answer.setFont(font);

		//�Է� ��ư�� Ŭ���̺�Ʈ ����
		btn.addActionListener(new ActionListener() {
			//�Է��� ������ showAnswer�� ������
			@Override
			public void actionPerformed(ActionEvent e) {
				inAout.check_inputStringRecord(fPlay, tfUser.getText().trim(), lh.getAns());
				showAnswer.setText(inAout.outputString.toString());
				tfUser.setText("");
				tfUser.requestFocus();
				
				inAout.SucAndFail(lh.getAns());
			}
		});
		
		//�Է� ��ư�� �����Է�Ű ����
		tfUser.addKeyListener( new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					inAout.check_inputStringRecord(fPlay, tfUser.getText().trim(), lh.getAns());
					showAnswer.setText(inAout.outputString.toString());
					tfUser.setText("");
					tfUser.requestFocus();
					
					inAout.SucAndFail(lh.getAns());
				}
			}
			
		});
		
		
		//fPlay.add(j);
		fPlay.setFont(font);
		fPlay.setResizable(false);
		fPlay.add(answer);

		fPlay.add(test);
		fPlay.add(hint);
		fPlay.add(showAnswer);

		fPlay.setVisible(true);



		fPlay.addWindowListener( new WindowAdapter() {   
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		} );



	}   



}
