package com.zomy2000.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x,y;
	protected ID id;
	protected float VelX, VelY;
	protected double VelAngleR, Vel, VelAngleD;
	protected float Xacc;
	protected float Yacc ;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id =id;
	}
	
	public abstract void tick();	
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract Rectangle getBounds2();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void Vel(float y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public float getVelX() {
		return VelX;
	}

	public void setVelX(float velX) {
		this.VelX = velX;
	}

	public float getVelY() {
		return VelY;
	}

	public void setVelY(float velY) {
		this.VelY = velY;
	}

	public float getXacc() {
		return Xacc;
	}

	public void setXacc(float xacc) {
		Xacc = xacc;
	}

	public float getYacc() {
		return Yacc;
	}

	public void setYacc(float yacc) {
		Yacc = yacc;
	}
	
	
	
	
	
}
