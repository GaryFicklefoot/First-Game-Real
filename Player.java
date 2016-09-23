package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;
	
	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		

	}
	//sets bounds for hit detection
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,32,32);
	}
	
	public void tick()
	{
		//Moves postion of object with velocity
		
		x += volX;
		y += volY;
		//cannot go outside the sides fo the game
		x = Game.clamp(x, 0, Game.WIDTH -37);
		//cannot go throught the ceiling or floor of the game
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		//sets trail for player not necessary but looks cool
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 32, 32, 0.05f, handler));
		
		collision();
	}
	
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{   //gets every instance of objects in the game
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy)//tempobject is now basic enemy
			{
				if(getBounds().intersects(tempObject.getBounds())) //if rectangles touch
				{//collision code
					HUD.Health -= 2;
				}
			}
		}
	}
	
	public void render(Graphics g)
	{
		//creating grpahics g and casting it to graphics2d
		Graphics2D g2d =  (Graphics2D) g;
		//sets colors and sizes for plyaers
		
		if(id == ID.Player) g.setColor(Color.white);
		if(id == ID.Player2) g.setColor(Color.CYAN);
		g.fillRect(x, y, 32, 32);
	}
	
	
}
