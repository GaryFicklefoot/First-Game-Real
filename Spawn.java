package com.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	
	private HUD hud;
	
	private int scoreKeep = 0;
	
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud) 
	{
		this.handler = handler;
		this.hud=hud;
		
		
	}
	public void tick()
	{
		scoreKeep++;
		//everytime score gets to 500 level goes up one
		if(scoreKeep >= 250)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			//spawns enemies each level
			//sets it to -50 so they dont spawn on border of the world
			if(hud.getLevel() == 2){
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel() == 3){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel() == 4){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
		  }else if(hud.getLevel() == 5){
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
	}
	}
	}	
}