package com.zomy2000.main;

import java.awt.Color;
import java.awt.Graphics;


public class HUD {

	public static float Health = 1;
	private int score = -1;
	
	
	public void tick() {

		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		if(score>0)
		g.drawString("Score "+ score, 295, 15);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	
}
