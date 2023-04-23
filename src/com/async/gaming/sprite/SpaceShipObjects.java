package com.async.gaming.sprite;

import java.awt.image.BufferedImage;

import com.async.gaming.utils.GameConstants;
import com.async.gaming.utils.SpaceShipConstants;

public  class SpaceShipObjects implements GameConstants,SpaceShipConstants{
protected int x;
protected int y;
protected int w;
protected int h;
protected int dx;
protected int dy;
protected boolean isAlive;
protected BufferedImage image;
protected BufferedImage sImage;



//SETTERS AND GETTERS
public BufferedImage getSubImage() {
	return sImage;
}

public void setSubImage(BufferedImage subImage) {
	this.sImage = subImage;
}
public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getW() {
	return w;
}

public void setW(int w) {
	this.w = w;
}

public int getH() {
	return h;
}

public void setH(int h) {
	this.h = h;
}

public int getDx() {
	return dx;
}

public void setDx(int dx) {
	this.dx = dx;
}

public int getDy() {
	return dy;
}

public void setDy(int dy) {
	this.dy = dy;
}

public boolean isAlive() {
	return isAlive;
}

public void setAlive(boolean isAlive) {
	this.isAlive = isAlive;
}

//DEFAULT CONSTRUCTOR...
public SpaceShipObjects() {
	
}
//
//Methods
public void movementLeft() {
	x-=1;
	System.out.println(x);
}
public void movementRight() {
	x+=1;
	System.out.println(x);
}
//Printing the default image


}
