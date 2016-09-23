package com.main;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	
	//needs an instance of a handler object because we are gonna need it later
	private Handler handler;
	
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		//setting variable to a letter binding to when we press a key board key
		//going to display number value with the key you pressed
		int key = e.getKeyCode();
		System.out.println(key);
		
		//loops through all objects in the game if id matches it moves that object
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			//cannot do both at the same time becasue not multiple threading
			//works faster to use velocity becasue we are only adding 1 to the velocity when the key is pressed
			if(tempObject.getId() == ID.Player)
			{ //key events for player 1
				//moves player 1 uses velocity becasue runs better
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-5); 
				keyDown[0]=true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(5);    
				keyDown[1]=true;}
				if(key == KeyEvent.VK_D){ tempObject.setVelX(5);  
				keyDown[2]=true;}
				if(key == KeyEvent.VK_A){ tempObject.setVelX(-5);  
				keyDown[3]=true;}
			}
			/* for a second player if i want to add one
			if(tempObject.getId() == ID.Player2)
			{//key events player 2
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
			}*/
		}
		//quits the game out if key press esc is used
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			//SETS THE MOVEMENTS TO STOP IF THE KEY IS RELEASED
			//JUST COPY AND PASTE THE KEYS BUT SET THE CHANGE == 0
			if(tempObject.getId() == ID.Player)
			{ 
				if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(0);
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				
				//Horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
			/* for player 2 if i want to add one later
			if(tempObject.getId() == ID.Player2)
			{
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
			}*/
		}
	}

}
