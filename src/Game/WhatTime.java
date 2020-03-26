package Game;

public class WhatTime extends Thread{
	private int count = 0;
	
	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
