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
		
		//정답, 힌트 불러오기
		LoadHint lh = new LoadHint();
		
		//위의 코드로 대체 할 영역(이미지 보여지는 칸)
		ImageIcon img = new ImageIcon("playimg.jpg");
		JLabel j = new JLabel(img);
		j.setBounds(100, 0, 190, 250);
       

		//힌트가 보여지는 영역
		TextArea hint = new TextArea(lh.showHint(0)+"\n", 0, 290, TextArea.SCROLLBARS_NONE);
		hint.setEditable(false);
		hint.setBounds(0, 290, 600, 150);

		//입력한 정답이 보여지는 영역 (_)
		InandOut inAout = new InandOut(lh, hint, lh.getAns(),gameplayframe,j);
		TextArea showAnswer = new TextArea("", 0, 445, TextArea.SCROLLBARS_NONE);
		
		//***
		showAnswer.setText(inAout.outputString.toString());

		//showAnswer.setBackground(Color.GRAY);
		showAnswer.setEditable(false);
		showAnswer.setBounds(0, 445, 600, 90);

		//User정답 입력 칸
		Panel answer = new Panel();

		TextField tfUser = new TextField(15);
		Button btn = new Button(" Enter ");

		answer.setBounds(0, 540, 400, 80);
		answer.add(tfUser);
		answer.add(btn);
		answer.setFont(font);

		//입력 버튼에 클릭이벤트 감지
		btn.addActionListener(new ActionListener() {
			//입력한 정답이 showAnswer로 보여짐
			@Override
			public void actionPerformed(ActionEvent e) {
				inAout.check_inputStringRecord(gameplayframe, tfUser.getText().trim(), lh.getAns());
				showAnswer.setText(inAout.outputString.toString());
				tfUser.setText("");
				tfUser.requestFocus();
				inAout.SucAndFail(lh.getAns());
			}
		});

		//입력 버튼에 엔터입력키 감지
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
