package com.async.gaming.sprite;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.async.gaming.utils.AlienConstants;
import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.StopWatch;

public class GroupAliens extends AlienObject implements AlienConstants,GameConstants{
	private Aliens alienMatrix[][]=new Aliens[5][10];
	private int[] deadAlienArray = {-1,-1}; // Dead alien location in aliens array
	private boolean goRight,pos1;
	private int speed;
	StopWatch sw;
	
	
	Random rm = new Random();
	
	private int AlienNumber=total_ALIENS;
	
	public GroupAliens() throws IOException {
		image=ImageIO.read(GroupAliens.class.getResource(sprite));
		initialArrayMatrix();
		goRight=true;
		pos1=true;
		speed=A_SPEED;
		sw=new StopWatch();
	}
	
	private void initialArrayMatrix() throws IOException {
		for(int col=0; col<10; col++) {
			alienMatrix[0][col] = new Aliens(A_XPOS + (33 + A_COLGAP) * col, 
					A_INI,"alienH1.png" , "alienH2.png");
			for(int line=1; line<3; line++) {
			alienMatrix[line][col] = new Aliens(A_XPOS + (33 + A_COLGAP) *
						col, A_INI + A_LINEGAP * line,"alienM1.png","alienM2.png" );
			}
			for(int line=3; line<5; line++) {	
				alienMatrix[line][col] = new Aliens(A_XPOS + (33 + A_COLGAP)
					* col, A_INI + A_LINEGAP * line,"alienB1.png" ,"alienB2.png" );
			}	
		}
	}
	
	
private boolean isLeftEdgeWindow() {
//	Method that detects the left edge of the window
	boolean response=false;
	for(int col=0;col<10;col++) {
		for(int line=0;line<5;line++) {
			if(alienMatrix[line][col]!=null) {				
				if(alienMatrix[line][col].getX()<WINDOW_MARGIN) {
					response=true;
					break;
				}
			}
		}
	}
	return response;
}


private boolean isRightEdgeWindow() {
//	Method that detects the right edge of the window
	boolean response=false;
	for(int col=0;col<10;col++) {
		for(int line=0;line<5;line++) {
			if(alienMatrix[line][col]!=null) {				
				if(alienMatrix[line][col].getX() > GWIDTH-AWIDTH-A_DX-WINDOW_MARGIN) {
					response=true;
					break;
				}
			}
		}
	}
	return response;
}


public void alienRotates() {
	if(isRightEdgeWindow()==true) {	
		for(int col=0;col<10;col++) {
			for(int line=0;line<5;line++) {
				if(alienMatrix[line][col]!=null) {					
					alienMatrix[line][col].setY(alienMatrix[line][col].getY()+A_DY);
				}
			}
		}
		goRight=false;
		if(speed<9) {speed++;}}
		else {
			if(isLeftEdgeWindow()==true) {
				for(int col=0;col<10;col++) {
					for(int line=0;line<5;line++) {
						if(alienMatrix[line][col]!=null) {							
							alienMatrix[line][col].setY(alienMatrix[line][col].getY()+A_DY);
						}
					}
				}
				goRight=true;
				if(speed<9) {speed++;
				}
			}
		}
	}

	
	public void drawAliens(Graphics g) {
		if(StopWatch.laps %(100-10*speed)==0) {
			aliensMovement() ;}
//		Draw the aliens contained in the arrAlien array
			for(int col=0;col<10;col++) {
				for(int line=0;line<5;line++) {
					if(alienMatrix[line][col]!=null) {
						alienMatrix[line][col].imagechoice(pos1);
						g.drawImage(alienMatrix[line][col].getImg(), alienMatrix[line][col].getX(),alienMatrix[line][col].getY(),alienMatrix[line][col].getW(),alienMatrix[line][col].getH(), null);
					}
				}
			}
		
		}
	
	
	public void aliensMovement() {
		if(deadAlienArray[0]!=-1) {
			eliminateDeadAlien(deadAlienArray);
			deadAlienArray[0]=-1;
		}
//		Method that manages the movement of aliens
		if(goRight==true) {
			for(int col=0;col<10;col++) {
				for(int line=0;line<5;line++) {
					if(alienMatrix[line][col]!=null) {						
						alienMatrix[line][col].setX(alienMatrix[line][col].getX() + A_DX);
					}
				}
			}
		}
		else{
			for(int col=0; col<10; col++) {
				for(int line=0; line<5; line++) {
					if(alienMatrix[line][col]!=null) {						
						alienMatrix[line][col].setX(alienMatrix[line][col].getX() - A_DX);
					}
		}
	}
}
		if(pos1 == true) {pos1 = false;} 
		else {pos1 = true;}
				// Updated direction of movement if an alien reaches the edge of the window
				alienRotates();
	}
	
	public void shotTouchAlien(SpaceShipShoot sss) {
//		 Detect spaceship shot contact with alien		
		for(int col=0; col<10; col++) {
			for(int line=0; line<5; line++) {
				if(alienMatrix[line][col] != null) {
					if(sss.killAlien(alienMatrix[line][col]) == true) {
						alienMatrix[line][col].isAlive = false;// We kill the alien
						sss.y = -1; // We kill the shot
						// We save the position of the dead alien in the array
						deadAlienArray[0] = line;
						deadAlienArray[1] = col; 
						break;
					}
				}					
			}					
		}
	}
	

	private void eliminateDeadAlien(int[] deadAlienArray) {
		// Method that removes the dead alien from the array (null box)
		alienMatrix[deadAlienArray[0]][deadAlienArray[1]] = null;
		AlienNumber--;
		}
	
	public int[] choiceAlienShot() {
		// Returns the position of an alien drawn at random in arrAlien at the bottom of its
		int AlienPos[] = {-1,-1};		
		if(AlienNumber != 0) { // We check that there are still living aliens

			do {int col = rm.nextInt(10);// We randomly draw a column from the
					
				for(int line=4;line>=0;line--) { // We are looking for the 1st living alien
					// starting from the bottom		
					if(alienMatrix[line][col]!= null) {
						AlienPos[0] = alienMatrix[line][col].getX();
						AlienPos[1] = alienMatrix[line][col].getY();
						break;
					}
				}
			} while(AlienPos[0] == -1);
		}	
		return AlienPos;
	}
	

}
