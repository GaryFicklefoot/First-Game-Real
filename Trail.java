package com.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject
{
	
	private float alpha = 1;
	private Handler handler;
	private Color color; 
	private int width, height; 
	private float life;
	//life = 0.001 - 01
	//sincce its decimal must be float
	
	//every tick by the object will create a trail
	//makes the trail fade by subtracting it by 1
	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		//sets color to whatever color the enemy is
		this.color=color;
		//sets width of trail ot whatever size the enemy is
		this.width = width;
		this.height = height;
		this.life = life;
		
	}

	private AlphaComposite makeTransparent(float alpha)
	{//render out the transparencies in the object
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}
	
	public void tick() 
	{//longer the life is the longer the trail will be
		if(alpha > life)
		{
			alpha -= (life - 0.00001f);
		}else handler.removeObject(this);
		//sets size of the trail 
	}

	
	public void render(Graphics g) 
	{
		//must convert because alpha composite can only be used in Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g2d.setComposite(makeTransparent(1));
		//allows transparencies to fade without any later problems
	}

	//this is never gonna be used but must be implemented cause extends GameObject by trail
	public Rectangle getBounds() 
	{
		return null;
	}

}
