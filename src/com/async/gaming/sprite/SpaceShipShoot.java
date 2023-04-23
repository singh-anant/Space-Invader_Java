package com.async.gaming.sprite;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;


import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.ShieldsConstants;
import com.async.gaming.utils.SpaceShipConstants;

public class SpaceShipShoot extends SpaceShip implements GameConstants,SpaceShipConstants,ShieldsConstants{
  private boolean isspaceShipFiring=false;
	public SpaceShipShoot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		x=0;
		y=SS_YPOS-SS_SHOT_HEIGHT;
		w=SS_SHOT_WIDTH;
		h=SS_SHOT_HEIGHT;
		dx=0;
		dy=SS_SHOT_DY;
		image=ImageIO.read(SpaceShip.class.getResource(sprite));
	    sImage=image.getSubimage(179, 439, 11, 28);	
	}
 public boolean SpaceShipFire() {
	 return isspaceShipFiring;
 }
 
 public void setSpaceShoot(boolean ShipFiring) {
	 this.isspaceShipFiring=ShipFiring;
 }
 
 public int movementOfSpaceShipShot() {
	 if(isspaceShipFiring==true) {
		 if(y>0) {
			 y-=SS_SHOT_DY;
		 }
		 else isspaceShipFiring=false;
	 }
	 return y;
 }
 
 public boolean killAlien(Aliens alien) {
//	 the shot from the Spaceship destroys an alien
		if(y < alien.getY()+ alien.getH() 
			&& y + h> alien.getY() 
			&& x + w > alien.getX() 
			&& x< alien.getX() + alien.getW()){
				return true;
			} 
		else{return false;}
	}
 

 
  public void drawSpaceShipShot(Graphics g) {
	  if(isspaceShipFiring==true) {
		  g.drawImage(sImage, x, movementOfSpaceShipShot(), w,h, null);
	  }
  }
 
}
