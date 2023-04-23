package com.async.gaming.sprite;

import java.awt.Graphics;
//import java.io.IOException;
import java.util.Random;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.async.gaming.utils.AlienConstants;
import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.StopWatch;

public class AlienShoot extends AlienObject implements GameConstants,AlienConstants{
	Random rm = new Random();
	
	public AlienShoot(int AlienPosition[]) {
		x=AlienPosition[0]+AWIDTH/2-1;
		y=AlienPosition[1]+AHEIGHT;
		w=Alien_Shots_WIDTH;
		h=Alien_Shots_HEIGHT;
		dx=0;
		dy=Alien_Shots_DY;
//		image=ImageIO.read(AlienShoot.class.getResource(sprite));
		img1="AlienShot1.png";
		img2="AlienShot2.png";
		img3="";
//		sImage1=image.getSubimage(438, 1892, 11 , 40);
		// Load the alien shot image
		if(rm.nextInt(2) == 0) {
			icon = new ImageIcon(getClass().getResource(img1));}
		else {icon = new ImageIcon(getClass().getResource(img2));}
		img = icon.getImage();
	}
	
	public int alienShotMovement() {
		if(StopWatch.laps % 4 == 0) {
			if(y < 600) {y = y + Alien_Shots_DY;}			
		}
		return y;
	}
	
	public void drawAlienShot(Graphics g) {
		g.drawImage(img,x,alienShotMovement(), w, h, null);
	}
}
