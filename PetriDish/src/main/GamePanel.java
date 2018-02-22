package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	static final int STATE_MENU = 0, STATE_SIM = 1;
	Timer refresh;
	int rate = 1000/60;
	int timer;
	Environment world;

	public GamePanel() {
		refresh = new Timer(rate, this);
		world = new Environment();
	}

	void startGame() {
		refresh.start();
	}

	void updateGame() {
		world.update();
	}

	void drawGame(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 800, 800);
		world.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateGame();
		repaint();
		if(timer >= 300) {
			world.checkMitosis();
			timer = 0;
		} else {
			timer++;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		drawGame(g);
	}
}
