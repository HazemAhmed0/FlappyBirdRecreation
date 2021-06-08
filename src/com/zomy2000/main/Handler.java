package com.zomy2000.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	
	public void tick() {
		for(int i = 0 ; i < object.size() ; i++) {
			GameObject temp = object.get(i);
			
			temp.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0 ; i < object.size() ; i++) {
			GameObject temp = object.get(i);
			
			temp.render(g);
		}
	}

	
	public void ClearBoard() {
			object.clear();
	}
	

	
	public void AddObject (GameObject object) {
		this.object.add(object);
	}
	
	public void RemoveObject (GameObject object) {
		this.object.remove(object);
	}
	
	
}
