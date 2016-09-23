package com.main;

import java.util.LinkedList;
import java.awt.Graphics;

//Maintains updates and renders all the objects in the game
//loops through all objecgts in the game and renders them to the screen
public class Handler 
{

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		for(int i = 0; i<object.size(); i++)
		{
			//setting tempobject to a function in linked list that allows us to get the id of what object we are at
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}//loops through all objects
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i <object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}//loops through all tick method and renders all game objects
	}
	//add or remove objects from our list
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
}
