package com.zomy2000.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

public class HS {

	private int[] Top5 = { 0, 0, 0, 0, 0 };

	public boolean check(int score) {

		if (score > Top5[0])
			return true;
		else
			return false;
	}

	public void AddScore(int score) {
		// System.out.println("Got in");
		Top5[0] = score;
	}

	public void tick() {
		Arrays.sort(Top5);
	}

	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 40);
		Font fnt2 = new Font("arial", 1, 25);
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("HIGHSCORES", 180, 70);
		g.setFont(fnt2);
		int l =0;
		for (int i = 4; i >=0; i--) {

			g.drawString("Name" + (l + 1) + "............................" + Top5[i], 180, 170 + (50 * l));
			l++;
		}

	}

}
