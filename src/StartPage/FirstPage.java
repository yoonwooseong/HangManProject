package StartPage;
import UserIdCreate.*;
import UserLogin.*;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UserLogin.C_Login_F;
import UserLogin.*;
public class FirstPage {

public static void main(String[]arg) {
		
		Frame mainframe = new Frame("Hangman game");
		mainframe.setLayout(null);
		mainframe.setBounds(700, 200, 400, 600);
		Font font = new Font("",Font.BOLD,20);
		
		Button id = new Button("ID 로그인");
		id.setBounds(130,300,150,60);
		id.addActionListener(new ActionListener() {
			
			C_Login_F login_Frame = new C_Login_F();
			@Override
			public void actionPerformed(ActionEvent e) {
				
				login_Frame.logInFrame(mainframe);
				
			}
		});
		
		
		Button createId = new Button("ID 생성");
		createId.setBounds(130,400,150,60);
		createId.addActionListener(new ActionListener() {
		
			CId_Create_F create_Frame = new CId_Create_F();
			@Override
			public void actionPerformed(ActionEvent e) {
				
				create_Frame.createFrame();
				
				
			}
		});
		
		Button rank = new Button("기록 /랭크 보기");
		rank.setBounds(130,500,150,60);
		rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
			}
		});
		
		
		ImageIcon mainimg = new ImageIcon("hangmain.jpg");
		JLabel j1 = new JLabel(mainimg);
		j1.setBounds(130,60,258,195);
		
	
		mainframe.add(id);
		mainframe.add(createId);
		mainframe.add(rank);
		mainframe.add(j1);
		
		mainframe.setFont(font);
		mainframe.setResizable(false);//프레임사이즈 변경불가 
		mainframe.setVisible(true);
		
		//종료
		mainframe.addWindowListener( new WindowAdapter() {	
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					};
				} );
	
	
}
}
