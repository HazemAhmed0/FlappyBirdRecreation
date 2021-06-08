package com.zomy2000.main;


public class Spawn {

	private Handler handler;
	private HUD hud;
	private float ScoreKeep;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;

	}

	public void tick() {
		ScoreKeep++;
		if (ScoreKeep >= 100) {
			ScoreKeep -= 100;
			hud.setScore(hud.getScore()+1);
			handler.AddObject(new Obstacle(640, 0, ID.Obstacle));
		}

	}
}

