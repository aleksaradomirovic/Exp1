package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class PetriDish {
	JFrame frame;
	GamePanel panel;

	public PetriDish() {
		frame = new JFrame();
		panel = new GamePanel();

	}

	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 800));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		panel.startGame();
	}

	public static void main(String[] args) {
		new PetriDish().setup();
	}
}
