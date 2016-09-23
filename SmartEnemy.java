package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject
{
	
	private Handler handler;

	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) 
	{
		super(x,y,id);
		this.handler = handler;
		
		for(int i =0; i <handler.object.size(); i++)
		{
			if(handler.object.get(i).getId() == ID.Player)
			{
				player =handler.object.get(i);
				//searches linkedl list and puts player  = to the player in the llist
			}
		}
		
	}
	
	//sets bounds for hit detection
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,16,16);
	}
	
	public void tick() 
	{
		x+= volX;
		y+= volY;
		
		//alogrithim to have it follow th eplayer 
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float)Math.sqrt((x - player.getX())*(x-player.getX()) + (y-player.getY())*y-player.getY());
		
		volX = (int)((-1.0/distance) + diffX);
		volY = (int)((-1.0/distance) + diffY);
		
		//when the enemy gets to the top of the screen it reverses the velocity and makes it go the other way
		if(y<=0 || y >= Game.HEIGHT - 32) volY *= -1;
		// when the enemy gets to the sides of the screen it reverses velocity and makes it go the other way
		if(x<=0 || x >= Game.WIDTH - 16) volX *= -1;
		//sets size of trail
		handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.02f, handler));
	}


	public void render(Graphics g) 
	{
		//sets the color and size of the enemy class basic
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 16, 16);
		
	}

}
