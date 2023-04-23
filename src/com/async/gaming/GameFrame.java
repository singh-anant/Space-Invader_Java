package com.async.gaming;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.async.gaming.utils.GameConstants;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements GameConstants {
	public GameFrame() throws IOException {
		setResizable(false);
		setTitle(GTITLE);
		setSize(GWIDTH,GHEIGHT);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard gb=new GameBoard();		
		add(gb);
		setVisible(true);
	}
	public static void main(String[] args) {
		GameFrame ob=null;
	     try {
	    	 ob=new GameFrame();
	     }
	     catch(Exception e) {
	    	 JOptionPane.showMessageDialog(ob, "Something not right");
				e.printStackTrace();
	     }
	}
}

