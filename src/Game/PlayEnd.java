package Game;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

public class PlayEnd {

	public void playEnd(int endTimimg) {
		Frame playEndFrame = new Frame();
		playEndFrame.setLayout(null);
		playEndFrame.setBounds(700, 200, 400, 600);
		Font font = new Font("", Font.BOLD, 20);

		String second = "���� ����??";
		JLabel count = new JLabel(second);//�����忡�� �� �ҷ�����
		count.setVisible(true);
		count.setBounds(0, 50, 400, 100);
		count.setOpaque(true);//����
		count.setBackground(Color.WHITE);
		count.setHorizontalAlignment(JLabel.CENTER);//��Ʈ �������
		count.setFont(font);

		//���� ���� �� ���ڿ�
		if(endTimimg == 1) {           
			String success = "�����մϴ� ����!";
			JLabel endSuccess = new JLabel(success);          
			endSuccess.setVisible(true);
			endSuccess.setBounds(0, 200, 400, 150);
			endSuccess.setOpaque(true);
			endSuccess.setBackground(Color.yellow);
			endSuccess.setHorizontalAlignment(JLabel.CENTER);
			endSuccess.setFont(font); 
			playEndFrame.add(endSuccess);           
		}

		//���� ���� �� ���ڿ�
		if(endTimimg == 2) {
			String fail = "����...�ٽ� �����ϼ���";
			JLabel endFail = new JLabel(fail);
			endFail.setVisible(true);           
			endFail.setBounds(0, 200, 400, 150);
			endFail.setOpaque(true);
			endFail.setBackground(Color.lightGray);
			endFail.setHorizontalAlignment(JLabel.CENTER);
			endFail.setFont(font);
			playEndFrame.add(endFail);
		}



		Button replay = new Button("�ٽ� �ϱ�");
		replay.setBounds(210, 420, 170, 90);
		replay.addActionListener(new ActionListener() {
			GameStartView gvs = new GameStartView();

			@Override
			public void actionPerformed(ActionEvent e) {

				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
				gvs.GameStartView();

			}
		});


		Button lank = new Button("��ŷ Ȯ��");
		lank.setBounds(20, 420, 170, 90);

		playEndFrame.setFont(font);
		playEndFrame.add(count);
		playEndFrame.add(lank);
		playEndFrame.add(replay);
		playEndFrame.setResizable(false);
		playEndFrame.setVisible(true);



		//����
		playEndFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GameFrame.gameplayframe.dispose();
				playEndFrame.dispose();
			};
		});  
	}

}
