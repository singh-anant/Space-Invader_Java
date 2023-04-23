package com.async.gaming.sprite;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.SpaceShipConstants;

public class SpaceShip extends SpaceShipObjects implements GameConstants,SpaceShipConstants {
     
	
	public SpaceShip() throws IOException {
		x=SS_XPOS;
		y=SS_YPOS;
		w=SSWIDTH;
		h=SSHEIGHT;
		dx=0;
		dy=0;
		image=ImageIO.read(SpaceShip.class.getResource(sprite));
		sImage=	image.getSubimage(356, 1158, 108, 70);
	}
	
	public int spaceShipMovementRestriction() {
		// Returns the new position of the ship after possible displacement
		if(dx<0) {
			if(x>LEFT_LIMIT_SHIP) {
				x+=dx;
			}
			}	
		else if(dx>0) {
			if(x+dx<RIGHT_LIMIT_SHIP) {
				x+=dx;
			}
		}
		return x;
	}
	
	public void drawSpaceShip(Graphics g) {
		g.drawImage(sImage,spaceShipMovementRestriction(),y,w,h,null);
	}

}
