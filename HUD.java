package com.main;

import java.awt.Color;
import java.awt.Graphics;

//not an actual game object so dont need that code
public class HUD 
{
	//not gonna have any other health variable in the game so we dont have ot initialize anything
	//can say hud.health to get it for ease
	public static int Health = 100;
	//full array of its color
	private int greenValue = 255;
	//sets the score
	private int score = 0;
	//sets the level
	private int level = 1;
	
	public void tick()
	{
		
		//health wont go 0 and above 100
		Health = Game.clamp(Health, 0, 100);
		//makes transition from green to red
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = Health * 2;
		
		score++;
	}

	public void render(Graphics g)
	{
		//sets background for hud
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		//sets green health part of hud and red part and no blue
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, Health * 2, 32);
		//sets border around health bar
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		//sets where score and levle will be
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
	}
	
	public void score(int score)
	{
		this.score = score;
	}
	public int getScore()
	{
		return score;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
}
