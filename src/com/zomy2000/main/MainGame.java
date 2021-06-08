package com.zomy2000.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class MainGame extends Canvas implements Runnable {

	private static final long serialVersionUID = 2921503504258276518L;
	private Thread thread;
	private boolean running = false;
	public static final float width = 640;
	public static final float height = width / 12 * 9;
	private Handler handler;
	private HUD hud;
	private int fps;
	private Spawn spawn;
	private Menu menu;
	private HS hs;
	public static boolean paused = false;
	public static BufferedImage Sprite_Sheet;
	private BufferedImage BackGround;

	public enum STATE {
		Menu, Game, HS, Dead;
	}

	public STATE GameState = STATE.Menu;

	public MainGame() {
		BufferedImageLoader loader = new BufferedImageLoader();
		Sprite_Sheet = loader.LoadImage("/Sprite_Sheet2.png");
		SpriteSheet ss = new SpriteSheet(MainGame.Sprite_Sheet);
		BackGround = ss.GrabImage(0, 0, 640, 480);
		handler = new Handler();
		hud = new HUD();
		spawn = new Spawn(handler, hud);
		menu = new Menu(this, handler);
		hs = new HS();
		this.addKeyListener(new KeyInput(handler, this, hud));
		this.addMouseListener(menu);
		new Window(width, height, "Flappy Bird ReCreation", this);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();

			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;

				frames = 0;
			}
		}
		stop();

	}

	private void tick() {

		if (HUD.Health < 1 && GameState == STATE.Game) {
			if (hs.check(hud.getScore())) {
				hs.AddScore(hud.getScore());
			}
			GameState = STATE.Dead;
			handler.ClearBoard();
		}

		if (!paused) {
			handler.tick();

			if (GameState == STATE.Game) {
				hud.tick();
				spawn.tick();
			}
		}
		if (GameState == STATE.Menu) {
			menu.tick();
		}
		if (GameState == STATE.HS) {
			hs.tick();
		}
		if (GameState == STATE.Dead) {
			menu.tick();
		}

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(BackGround, 0, 0, null);
		g.setColor(Color.black);
		//g.fillRect(0, 0, (int) width, (int) height);
		handler.render(g);
		g.setColor(Color.white);
		g.drawString(fps + " FPS", 560, 15);
		
		if (GameState == STATE.Game) {
			hud.render(g);
		}
		if (GameState == STATE.Menu) {
			menu.render(g);
		}
		if (GameState == STATE.HS) {
			hs.render(g);
		}
		if (GameState == STATE.Dead) {
			menu.render(g);
		}
		if(MainGame.paused) {
			g.setColor(Color.white);
			Font fnt3 = new Font("arial", 1, 50);
			g.setFont(fnt3);
			g.drawString("PAUSED", 220, 100);

		}

		g.dispose();
		bs.show();

	}

	public static float clamp(float var, float min, float max) {
		if (var > max) {
			return var = max;
		} else if (var < min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String args[]) {
		new MainGame();
	}

}
