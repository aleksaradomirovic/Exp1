package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Environment {
	ArrayList<Cell> life = new ArrayList<Cell>();
	ArrayList<Particle> particles = new ArrayList<Particle>();
	final char[] emptyGenome = {};

	public Environment() {
		newCell(emptyGenome, 400, 400);
		for(int i = 0; i < 100; i++) {
			newParticle(6,6,12,new Random().nextInt(801), new Random().nextInt(801));
		}
	}

	void newCell(char[] g, int x, int y) {
		life.add(new Cell(g, this, x, y));
	}
	void newParticle(int c, int o, int h, int x, int y) {
		particles.add(new Particle(c,o,h,x,y));
	}

	void checkMitosis() {
		int initSize = life.size();
		for (int i = 0; i < initSize; i++) {
			life.get(i).mito();
			System.out.println("Added cell");
		}
	}

	void draw(Graphics g) {
		for (int i = 0; i < life.size(); i++) {
			life.get(i).draw(g);
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).draw(g);
		}
	}
	
	void update() {
		for(int i = 0; i < life.size(); i++) {
			life.get(i).update();
			System.out.println("Cell ("+i+") updated");
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
	}
}
