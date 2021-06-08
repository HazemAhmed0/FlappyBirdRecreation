package com.zomy2000.main;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Obstacle extends GameObject {

	private Random r;

	private int h1;
	private int gap = 140;
	private BufferedImage Top;
	private BufferedImage Bottom;

	public Obstacle(float x, float y, ID id) {
		super(x, y, id);
		r = new Random();
		h1 = r.nextInt(200) + 50;

		SpriteSheet ss = new SpriteSheet(MainGame.Sprite_Sheet);
		
		Top = ss.GrabImage(845, 250-h1, 130, h1);
		Bottom = ss.GrabImage(675, 230, 130, 440 - (h1 + this.gap));
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x -= 4;
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Top, (int) x, (int) y, null);
		g.drawImage(Bottom, (int) x, (int) y + this.h1 + this.gap, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (h1 + this.gap), 140, 440 - (h1 + this.gap));
	}

	public Rectangle getBounds2() {
		return new Rectangle((int) x, (int) y, 140, h1);
	}

}
