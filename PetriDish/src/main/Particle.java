package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Particle {
	int energy, mass;
	Color partType;
	int c, o, h;
	int x,y;
	Rectangle hitbox;
	public Particle(int Carbon, int Oxygen, int Hydrogen, int x, int y) {
		energy = (Carbon*4) - (Oxygen*2) + Hydrogen;
		c = Carbon;
		o = Oxygen;
		h = Hydrogen;
		mass = (c*6 + o*8 + h)/10;
		partType = getColor();
		this.x = x;
		this.y = y;
		hitbox = new Rectangle();
	}
	
	void update() {
		hitbox.setBounds(x-(mass/2), y-(mass/2), mass, mass);
	}
	void draw(Graphics g) {
		g.setColor(partType);
		g.fillOval(x, y, mass, mass);
	}
	
	private Color getColor() {
		Color r;
		if(o > c) {
			if(h > o) {
				r = Color.WHITE;
			} else {
				r = Color.BLUE;
			}
		} else {
			if(h > c) {
				r = Color.WHITE;
			} else {
				r = Color.BLACK;
			}
		}
		return r;
	}
}
