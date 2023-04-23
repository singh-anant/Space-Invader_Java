package com.async.gaming.sprite;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class AlienObject {
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int dx;
	protected int dy;
	protected BufferedImage image;
	protected boolean isAlive;
	
	protected BufferedImage sImage1;
	protected BufferedImage sImage2;
	protected BufferedImage sImage3;
	protected String img1;
	protected String img2;
	protected ImageIcon icon;
	protected Image img;
	protected String img3;
	
	protected BufferedImage fImage;
	
	//SETTERS AND GETTERS
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public BufferedImage getfImage() {
		return fImage;
	}
	public void setfImage(BufferedImage fImage) {
		this.fImage = fImage;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
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
	public BufferedImage getsImage1() {
		return sImage1;
	}
	public void setsImage1(BufferedImage sImage1) {
		this.sImage1 = sImage1;
	}
	public BufferedImage getsImage2() {
		return sImage2;
	}
	public void setsImage2(BufferedImage sImage2) {
		this.sImage2 = sImage2;
	}
}
