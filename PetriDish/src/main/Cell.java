package main;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	char[] genome;
	Environment world;
	int x, y;
	// Random rnd = new Random();
	boolean mitosis = true;

	public Cell(char[] genome, Environment e, int parentX, int parentY) {
		this.genome = genome;
		world = e;

		x = parentX;
		y = parentY;
	}

	void update() {
		if (mitosis) {
			world.newCell(genome, x, y);
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 20, 20);
	}

}
