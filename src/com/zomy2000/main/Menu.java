package com.zomy2000.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import com.zomy2000.main.MainGame.STATE;

public class Menu extends MouseAdapter {

	MainGame game;
	Handler handler;


	public Menu(MainGame game, Handler handler) {
		this.game = game;
		this.handler = handler;

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (game.GameState == STATE.Menu) {
			if (OverTarget(mx, my, 220, 200, 200, 64)) {
				game.GameState = STATE.Game;
				handler.AddObject(new Player(MainGame.width / 2 - 16, MainGame.height / 2 - 16, ID.Player, handler, game));
			}
			if (OverTarget(mx, my, 220, 360, 200, 64)) {
				System.exit(0);
			}
			if (OverTarget(mx, my, 220, 280, 200, 64)) {
				// System.out.println("LeaderBoards");
				game.GameState = STATE.HS;
			}

		}
		if (game.GameState == STATE.Dead) {
			handler.ClearBoard();
			System.out.println("Dead");
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public boolean OverTarget(int mx, int my, int x, int y, int w, int h) {
		if (mx < (x + w) && mx > x) {
			if (my < (y + h) && my > y) {
				return true;
			}
		}
		return false;
	}

	public void render(Graphics g) {

		if (game.GameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			g.setColor(Color.green);
			g.setFont(fnt);
			g.drawString("FLAPPY", 220, 100);
			g.setColor(Color.black);
			g.setFont(fnt2);
			g.drawString("START", 270, 243);
			g.setFont(fnt3);
			g.drawString("HIGHSCORES", 255, 320);
			g.setFont(fnt2);
			g.drawString("QUIT", 285, 403);
			g.drawRect(220, 200, 200, 64);
			g.drawRect(220, 280, 200, 64);
			g.drawRect(220, 360, 200, 64);
		}
		if (game.GameState == STATE.Dead) {
			Font fnt = new Font("arial", 1, 50);
			g.setColor(Color.red);
			g.setFont(fnt);
			g.drawString("YOU DIED", 200, 200);
			Font fnt2 = new Font("arial", 1, 19);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Press ESC to continue", 220, 230);
		}

	}

	public void tick() {

	}

}
