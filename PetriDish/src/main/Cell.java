package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Cell {
	final int MOVE_RAND = 0;
	char[] genome;
	Environment world;
	int x, y;
	Random rnd = new Random();
	boolean mitosis = true;
	int moveGene = MOVE_RAND;
	int move_imp, ximp, yimp;
	Rectangle hitbox;
	int mass;

	public Cell(char[] genome, Environment e, int parentX, int parentY) {
		this.genome = genome;
		world = e;

		x = parentX;
		y = parentY;
		move_imp = 0;
		hitbox = new Rectangle();
		mass = 20;
	}

	void mito() {
		if (mitosis) {
			world.newCell(genome, x, y);
		}
	}
	
	void update() {
		movement();
		hitbox.setBounds(x-mass/2, y-mass/2, mass, mass);
		for(int i = 0; i < world.particles.size(); i++) {
			if(hitbox.intersects(world.particles.get(i).hitbox)) {
				world.particles.remove(i);
				i--;
			}
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 20, 20);
	}
	
	void movement() {
		if(moveGene == 0) {
			
			if(move_imp == 0) {
				move_imp = rnd.nextInt(10) + 1;
				yimp = rnd.nextInt(5) - 2;
				ximp = rnd.nextInt(5) - 2;
			}
			
			x += ximp;
			y += yimp;
			
			move_imp--;
		}
	}
}
