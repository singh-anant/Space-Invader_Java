package com.async.gaming;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.async.gaming.sprite.AlienShoot;
import com.async.gaming.sprite.GroupAliens;

//import com.async.gaming.sprite.Aliens;
import com.async.gaming.sprite.SpaceShip;
import com.async.gaming.sprite.SpaceShipShoot;
import com.async.gaming.utils.ShieldsConstants;
import com.async.gaming.utils.SpaceShipConstants;
import com.async.gaming.utils.StopWatch;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements SpaceShipConstants,ShieldsConstants{
	private Timer timer;
	private BufferedImage backgroundImage;
	private SpaceShip ss;
    private GroupAliens ga;
    private SpaceShipShoot sss;
    
    public AlienShoot AlienShot1,AlienShot2,AlienShot3;
	public GameBoard() throws IOException {
		setFocusable(true);
		requestFocusInWindow(true);
		loadBackgroundImage();
		gameIterator();
		bindingEvents();
		
		ss=new SpaceShip();
		ga=new GroupAliens();
		sss=new SpaceShipShoot();

	}
	private void gameIterator() {
		timer = new Timer(150,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				
			}
		});
		timer.start();
	}
	
	
	private void loadBackgroundImage() throws IOException {
		backgroundImage=ImageIO.read(GameBoard.class.getResource("bg.jpg"));
	}
	
	private void printBackgroundImage(Graphics g) {
		g.drawImage(backgroundImage,0,0,600,600,null);
	}
	
	private void bindingEvents() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
					ss.setDx(SS_DX);
//					System.out.println(ss.getDx());
				}
				else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
					ss.setDx(-SS_DX);
//					System.out.println(ss.getDx());
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(sss.SpaceShipFire()==false) {
						sss.setY(SS_YPOS-SS_SHOT_HEIGHT);
						sss.setX(ss.getX()+SSWIDTH/2 - 1);
						sss.setSpaceShoot(true);
					} 
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				ss.setDx(0);
				


			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g)  {

		super.paintComponent(g);
		printBackgroundImage(g);
		g.setColor(Color.GREEN);
		g.fillRect(30, 545, 535, 5);
		ss.drawSpaceShip(g);
		ga.drawAliens(g);
		sss.drawSpaceShipShot(g);
		ga.shotTouchAlien(sss);
	
		
		// Draw alien shots
		if (StopWatch.laps % 500 == 0)  {
			AlienShot1 = new AlienShoot(ga.choiceAlienShot());
		}
		if (AlienShot1 != null) {
			AlienShot1.drawAlienShot(g);
		}
		if (StopWatch.laps % 750 == 0) {
			AlienShot2 = new AlienShoot(ga.choiceAlienShot());
		}
		if (AlienShot2 != null) {
			AlienShot2.drawAlienShot(g);
		}
		if (StopWatch.laps % 900 == 0) {
			AlienShot3 = new AlienShoot(ga.choiceAlienShot());
		}
		if (AlienShot3 != null) {
			AlienShot3.drawAlienShot(g);
		}
	
	}
}
