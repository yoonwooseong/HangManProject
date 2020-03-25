package Game;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class InAndOut {

	StringBuffer outputString = new StringBuffer(); // 플레이어의 입력에 따른 결과로 보여줄 문자열
	String playerInputString;

	int rightCount;
	int wrongCount;

	public InAndOut(String ans) {

		rightCount = 0;
		wrongCount = 5;//기회
		for(int i = 0; i < ans.length(); i++) {
			outputString.append("*");
		}
	}//생성자

	public void check_inputStringRecord(Frame fPlay, String input, String ans){

		if(input.charAt(0) < 'a' || input.charAt(0) > 'z' || input.length() > 1) {
			//영 소문자 잘 입력하지 못하면
			JOptionPane.showMessageDialog(fPlay, "영 소문자 한개를 입력해주세요.");
			
		} else {
			//영 소문자 잘 입력
			//그런데 알파벳이 답에 없다면
			if(ans.indexOf(input.charAt(0)) == -1) {
				wrongCount--;
			}
			
			//알파벳에 답이 있는지 확인
			for(int i = 0; i < ans.length(); i++) {
				//알파벳이 답에 있다면
				if(ans.charAt(i) == input.charAt(0)) {
					outputString.replace(i, i+1, input);
					rightCount++;
				}
			}
		}

	}//입력값 확인 메서드
	
	//다맞췄을때와 틀렸을때
	public void SucAndFail(String ans) {
		//성공
		if(ans.length() == rightCount) {
			
			System.out.println("성공!!");
		}
		//실패
		if(wrongCount == 0) {
			
			System.out.println("탈ㄹㄹㄹㄹㄹㄹㄹㄹ락");
		}
	}
}