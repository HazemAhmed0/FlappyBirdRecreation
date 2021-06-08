package com.zomy2000.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sprite;

	public SpriteSheet(BufferedImage ss) {
		this.sprite = ss;
	}

	public BufferedImage GrabImage(int x, int y, int width, int hight) {
		BufferedImage img = sprite.getSubimage(x, y, width, hight);
		return img;
	}

}
