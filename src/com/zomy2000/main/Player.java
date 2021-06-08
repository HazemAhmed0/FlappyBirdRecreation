package com.zomy2000.main;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
	private Handler handler;
	MainGame game;
	private BufferedImage PlayerTexture;

	public Player(float x, float y, ID id, Handler handler, MainGame game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		SpriteSheet ss = new SpriteSheet(MainGame.Sprite_Sheet);
		
		PlayerTexture = ss.GrabImage(674, 0, 32, 32);
	}

	@Override
	public void tick() {

		Yacc = 0.3f;
		VelY += Yacc;
		VelY = MainGame.clamp(VelY, -10, 5);
		Yacc = MainGame.clamp(VelY, -2, 0.2f);
		y += VelY;
		if (y > 405 || y < 0) {
			HUD.Health = 0;
		}
		Collision();

	}

	private void Collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);

			if (temp.getId() == ID.Obstacle) {
				// general collision code
				if (getBounds().intersects(temp.getBounds()) || getBounds().intersects(temp.getBounds2())) {
					// collision with enemy
					HUD.Health = 0;
				}

			}

		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(PlayerTexture, (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	@Override
	public Rectangle getBounds2() {
		// TODO Auto-generated method stub
		return null;
	}

}
