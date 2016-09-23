/**
 * 
 */
package com.main;

import java.awt.Graphics;
import java.awt.Rectangle;

//All the game objects used for inhertance from characters to enemies
public abstract class GameObject {
	
	//can only be accessed by which object inherits the game object
	// does not have to be initialzied in inherited objects
	protected int x, y;
	//gives it id of enemy or player
	protected ID id;
	//gives speed of x and y direction
	protected int volX, volY;
	
	public GameObject(int x, int y, ID id)
	{
		//whatever we put into the parameters will set the protected int x y and id
		//for this object
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//every class must have these methods
	public abstract void tick();
	public abstract void render(Graphics g);
	//uses rectangles to handle all of the collisions
	public abstract Rectangle getBounds();
	//set values change the x y and id
	
	public void setX(int x)
	{
		//this refers to this instance and the protected int x
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	public void setId(ID id)
	{
		this.id = id;
	}
	public ID getId()
	{
		return id;
	}
	public void setVelX(int volX)
	{
		this.volX = volX;
	}
	public void setVelY(int volY)
	{
		this.volY = volY;
	}
	
	public int getVelX()
	{
		return volX;
	}
	public int getVelY()
	{
		return volY;
	}
	//all of these implemented methods are now in the player and enemy classes but do not need to be named
	//in class but hidden
}
