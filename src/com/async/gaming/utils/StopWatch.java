package com.async.gaming.utils;

import java.io.IOException;

import com.async.gaming.GameBoard;

public class StopWatch implements Runnable {
private final int PAUSE=5;
public static  int laps=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			laps++;
			try {
				new GameBoard().repaint();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
				Thread.sleep(PAUSE);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
 
}
