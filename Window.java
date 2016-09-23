package com.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{


	private static final long serialVersionUID = -2111860594941368902L;

	public Window(int width, int height, String title, Game game)
	{
		//creates a new frame from jframe frame of our window
		JFrame frame = new JFrame(title);
		//setting dimensions of frame
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		//having x button in top right corner to actually work
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Allows us to not reset window
		frame.setResizable(false);
		//window stops in middle of screen and not top left
		frame.setLocationRelativeTo(null);
		//adding our game class into our frame
		frame.add(game);
		//lets us see the frame
		frame.setVisible(true);
		//starting our game
		game.start();
		
	}
	
}

