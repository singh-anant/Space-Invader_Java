package com.async.gaming.sprite;

//import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.async.gaming.utils.AlienConstants;
import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.SpaceShipConstants;

public class Aliens extends AlienObject implements GameConstants,AlienConstants,SpaceShipConstants{
  
	public Aliens(int xPos,int yPos,String  s1,String s2)  {
		x=xPos;
		y=yPos;
		w=AWIDTH;
		h=AHEIGHT;
		dx=0;
		dy=0;
		isAlive=true;
//		image=ImageIO.read(Aliens.class.getResource(sprite));
//		sImage1=s1;
//		sImage2=s2;
		img1=s1;
		img2=s2;
		img3="alienD.png";
		icon = new ImageIcon(getClass().getResource(img1));
		img = icon.getImage();
//		sImage3=image.getSubimage(480, 1137, 104, 67);
		
	}
    
	public void imagechoice(boolean pos1) {
		// Method which loads the image of the alien according to its state and its position (1 or 2)
		if(isAlive == true) {
		if(pos1 == true) {icon = new ImageIcon(getClass().getResource(img1));}
		else {icon = new ImageIcon(getClass().getResource(img2));}
		}
		else {icon = new ImageIcon(getClass().getResource(img3));}
		img = icon.getImage();// reload the image
		}

		}

