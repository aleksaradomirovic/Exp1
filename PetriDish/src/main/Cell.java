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
	int storedC, storedO, storedH;
	int r, g, b;

	public Cell(char[] genome, Environment e, int parentX, int parentY, int mass) {
		this.genome = genome;
		world = e;

		x = parentX;
		y = parentY;
		move_imp = 0;
		hitbox = new Rectangle();
		this.mass = mass;
		storedC = 0;
		storedO = 0;
		storedH = 0;
		
		//ReadGenome
	}

	void mito() {
		if (mass >= 30) {
			world.newCell(genome, x, y, mass/2);
			mass = (int)mass/2;
		}
	}
	
	void update() {
		
		if(x > 850 || x < -50 || y > 850 || y < -50) {
			world.life.remove(this);
		}
		
		movement();
		hitbox.setBounds(x, y, mass, mass);
		for(int i = 0; i < world.particles.size(); i++) {
			Particle p = world.particles.get(i);
			
			if(hitbox.intersects(p.hitbox)) {
				mass += p.mass;
				storedC += p.c;
				storedO += p.o;
				storedH += p.h;
				
				world.particles.remove(i);
				i--;
			}
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, mass, mass);
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
	
	void runThroughGenome() {}
}
