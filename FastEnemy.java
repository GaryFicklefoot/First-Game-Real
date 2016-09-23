package com.main;


	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Rectangle;

	public class FastEnemy extends GameObject
	{
		
		private Handler handler;

		public FastEnemy(int x, int y, ID id, Handler handler) 
		{
			super(x,y,id);
			this.handler = handler;
			//moves the enemy around
			volX = 2;
			volY = 9;
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
			//when the enemy gets to the top of the screen it reverses the velocity and makes it go the other way
			if(y<=0 || y >= Game.HEIGHT - 32) volY *= -1;
			// when the enemy gets to the sides of the screen it reverses velocity and makes it go the other way
			if(x<=0 || x >= Game.WIDTH - 16) volX *= -1;
			//sets size of trail
			handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));
		}


		public void render(Graphics g) 
		{
			//sets the color and size of the enemy class basic
			g.setColor(Color.CYAN);
			g.fillRect(x, y, 16, 16);
			
		}

	}


