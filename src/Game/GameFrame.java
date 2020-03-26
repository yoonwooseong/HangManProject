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

	int rightCount = 0;
	int wrongCount = 5;
	static Frame gameplayframe = null;

	public void GamePlayView() {
		gameplayframe=new Frame();
		gameplayframe.setLayout(null);
		gameplayframe.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);
		
		//����, ��Ʈ �ҷ�����
		LoadHint lh = new LoadHint();
		
		//���� �ڵ�� ��ü �� ����(�̹��� �������� ĭ)
		ImageIcon img = new ImageIcon("playimg.jpg");
		JLabel j = new JLabel(img);
		j.setBounds(100, 0, 190, 250);
       

		//��Ʈ�� �������� ����
		TextArea hint = new TextArea(lh.showHint(0)+"\n", 0, 290, TextArea.SCROLLBARS_NONE);
		hint.setEditable(false);
		hint.setBounds(0, 290, 600, 150);

		//�Է��� ������ �������� ���� (_)
		InandOut inAout = new InandOut(lh, hint, lh.getAns(),gameplayframe,j);
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
				inAout.check_inputStringRecord(gameplayframe, tfUser.getText().trim(), lh.getAns());
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
					inAout.check_inputStringRecord(gameplayframe, tfUser.getText().trim(), lh.getAns());
					showAnswer.setText(inAout.outputString.toString());
					tfUser.setText("");
					tfUser.requestFocus();
					inAout.SucAndFail(lh.getAns());
				}
			}

		});

		//fPlay.add(j);
		gameplayframe.setFont(font);
		gameplayframe.setResizable(false);
		gameplayframe.add(answer);

		gameplayframe.add(j);
		gameplayframe.add(hint);
		gameplayframe.add(showAnswer);

		gameplayframe.setVisible(true);

		gameplayframe.addWindowListener( new WindowAdapter() {   
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		} );



	}//frame


	
}
