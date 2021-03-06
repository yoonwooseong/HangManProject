package UserIdCreate;
import StartPage.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class CId_Create_F {

	public void createFrame() {
		IdInfo_Path uPath = new IdInfo_Path();

		Frame id_createFrame = new Frame("아이디 생성 페이지");
		id_createFrame.setBounds(700, 400 ,400, 200);
		id_createFrame.setLayout(null);
		id_createFrame.setResizable(false);


		Label mainlabel = new Label("생성할 ID를 입력하세요");
		mainlabel.setBounds(110, 50, 230, 60);
		Font font  = new Font("",Font.BOLD,15);
		mainlabel.setFont(font);

		Panel pCenter = new Panel();
		pCenter.setBounds(50, 110, 300, 50);


		//아이디 입력 칸 생성
		TextField id = new TextField(15);
		id.setText(null);

		//등록 버튼생성 
		Button save=new Button("등록");
		save.setEnabled(false);

		//텍스트 영역 활성화 
		id.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub

				if(!id.getText().trim().equals("")) {
					save.setEnabled(true);
				}

			}
		});

		//버튼 영역 활성화
		//버튼 클릭시 중복 값 있으면 ->중복 ID 재입력!
		//중복 없으면 바로 아이디 생성
		CId_CreateWrite cWrite = new CId_CreateWrite();

		//클릭 감지
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cWrite.infoWrite(uPath, id, id_createFrame);

			} 
		});

		//엔터감지
		id.addKeyListener( new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					cWrite.infoWrite(uPath, id, id_createFrame);
				}

			}
		});

		pCenter.add(id);
		pCenter.add(save);
		id_createFrame.add(mainlabel);
		id_createFrame.add(pCenter,BorderLayout.CENTER);
		id_createFrame.setVisible(true);


		//종료
		id_createFrame.addWindowListener( new WindowAdapter() {	
			public void windowClosing(WindowEvent e) {
				id_createFrame.dispose();
			};
		} );

	}
}

