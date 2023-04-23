package com.async.gaming.utils;

public interface SpaceShipConstants extends GameConstants {
	int SSHEIGHT=50;
	int SSWIDTH=60;
	
	int SS_XPOS=(GWIDTH-SSWIDTH)/2;
	int SS_YPOS=490;
	
	int LEFT_LIMIT_SHIP=60;
	int RIGHT_LIMIT_SHIP=500;
	
	int SS_DX=8;
	
	// Shot movement unit
		int SS_SHOT_DY=20;
		int SS_SHOT_WIDTH=3;
		int SS_SHOT_HEIGHT=13;
}
