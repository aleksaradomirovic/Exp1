package main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Environment {
	ArrayList<Cell> life = new ArrayList<Cell>();
	final char[] emptyGenome = {};

	public Environment() {
		newCell(emptyGenome, 400, 400);
	}

	void newCell(char[] g, int x, int y) {
		life.add(new Cell(g, this, x, y));
	}

	void update() {
		int initSize = life.size();
		for (int i = 0; i < initSize; i++) {
			life.get(i).update();
			System.out.println("Added cell");
		}
	}

	void draw(Graphics g) {
		for (int i = 0; i < life.size(); i++) {
			life.get(i).draw(g);
		}
	}
}
