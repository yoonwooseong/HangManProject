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
		
		Frame id_createFrame = new Frame("���̵� ���� ������");
		id_createFrame.setSize(500,150);
		id_createFrame.setLayout(null);
		id_createFrame.setResizable(false);

		
		Label mainlabel = new Label("������ ID�� �Է��ϼ���");
	    mainlabel.setBounds(110, 50, 230, 60);
		Font font  = new Font("",Font.BOLD,20);
		mainlabel.setFont(font);

		//���̵� �Է� ĭ ����
		
		Panel pCenter = new Panel();
		pCenter.setBounds(50, 100, 300, 50);
		
		TextField id = new TextField(20);
		id.setText(null);
		pCenter.add(id);
		

		//��� ��ư���� 
		Button save=new Button("���");
		save.setBounds(400, 100, 60, 30);
		pCenter.add(save);
		
		//�ؽ�Ʈ ���� Ȱ��ȭ 
		 id.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				
				if(id.getText().equals("")) {
					save.setEnabled(false);
				}else {
					save.setEnabled(true);
				}
				
			}
		});
		 
		 //��ư ���� Ȱ��ȭ
		 //��ư Ŭ���� �ߺ� �� ������ ->�ߺ� ID ���Է�!
		 //�ߺ� ������ �ٷ� ���̵� ����
		 CId_CreateWrite cWrite = new CId_CreateWrite();
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			
				 cWrite.infoWrite(uPath, id, id_createFrame);

			} 
		});
		
		id_createFrame.add(pCenter,BorderLayout.CENTER);
		id_createFrame.add(mainlabel);
		id_createFrame.setVisible(true);
		
		//����

		id_createFrame.addWindowListener( new WindowAdapter() {	
			public void windowClosing(WindowEvent e) {
				id_createFrame.dispose();
			};
		} );
		
	}
}

