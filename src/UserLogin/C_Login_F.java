package UserLogin;
import StartPage.*;
import Game.*;
import UserIdCreate.IdInfo_Path;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class C_Login_F {
	public void logInFrame(Frame mainFrame) {

		//id�Է� ������
		Frame loginFrame = new Frame("LogIn");
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		Font guideFont = new Font("", Font.BOLD, 20);
		loginFrame.setLayout(null);
		loginFrame.setBounds(700, 400 ,400, 200);
		loginFrame.setVisible(true);

		//�Է�â
		Panel center = new Panel();

		TextField Id_tf = new TextField(15);
		Button btn = new Button("�α���");
		btn.setEnabled(false);//��ư��Ȱ��ȭ

		Label guide = new Label("ID�� �Է����ּ���.");
		guide.setVisible(true);
		guide.setBounds(110, 50, 230, 60);
		guide.setFont(guideFont);

		center.setBounds(50, 100, 300, 50);
		center.add(Id_tf);
		center.add(btn);
		center.setFont(font);
		loginFrame.add(center, BorderLayout.CENTER);
		loginFrame.add(guide);
		loginFrame.setResizable(false);

		//id �ѱ��ڶ� �Է� �ؾ� ��ư Ȱ��ȭ
		Id_tf.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				if( Id_tf.getText().trim().equals("") ) {
					btn.setEnabled(false);
				}else {
				}       btn.setEnabled(true);
			}
		});


		//�α��� �Է¹�ư ����
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String path = IdInfo_Path.PATH+Id_tf.getText()+"\\"+Id_tf.getText() + ".txt";
				//FileReader fr = null;
				File f = new File(path);

				if( !f.exists() ) {
					JOptionPane.showMessageDialog(loginFrame, "�������� �ʴ� Id�Դϴ�.\nId�� �����Ͻʽÿ�");
				}else {

					loginFrame.dispose();
					mainFrame.dispose();

					GameStartView gsv = new GameStartView();
					gsv.GameStartView();

				}//else


			}
		});
		
		//����

				loginFrame.addWindowListener( new WindowAdapter() {	
					public void windowClosing(WindowEvent e) {
						loginFrame.dispose();
					};
				} );
		
	
	}

}
