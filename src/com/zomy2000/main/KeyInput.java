package com.zomy2000.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zomy2000.main.MainGame.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private MainGame game;
	private HUD hud;

	public KeyInput(Handler handler, MainGame game, HUD hud) {
		this.handler = handler;
		this.game = game;
		this.hud = hud;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getId() == ID.Player) {
				// key events for player

				if (key == KeyEvent.VK_SPACE)
					temp.setVelY(-7);
				if (key == KeyEvent.VK_P) {
					if (MainGame.paused) {
						MainGame.paused = false;
					} else {
						MainGame.paused = true;
					}
				}
			}
		}

		if (key == KeyEvent.VK_ESCAPE) {
			handler.ClearBoard();
			game.GameState = STATE.Menu;
			HUD.Health = 100;
			hud.setScore(0);
		}
	}

}
