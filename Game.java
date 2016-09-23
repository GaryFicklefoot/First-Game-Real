package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable 
{
	//creates serial id
	private static final long serialVersionUID = 4088146271165387233L;
	
	//creates aspect ratio of game
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	
	//How the game runs through the thread one thread game
	private Thread thread;
	
	private boolean running = false;
	
	//random variable
	private Random r;
	private HUD hud;
	private Spawn spawner;
	
	//instance of our handler class
	private Handler handler;
	
	public Game()
	{
		//hanlder object put handler on top to prevent random error that may occur sometimes
		//game does not see it until it is initialized
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		//sets the windows size and height and default message at top
		new Window(WIDTH,HEIGHT,"First Game!", this);
		
		//creates the hud at the top of the screen
		hud = new HUD();
		//spawsn enenmies object
		spawner = new Spawn(handler,hud);
		r = new Random();
		
		//creates object for testing player class NOT NECESSARY
		//PUTS IT IN THE MIDDLE OF THE SCREEN
		handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player, handler));
		
		//randomly generates enemies
		
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		
		//handler.addObject(new Player(WIDTH/2+64,HEIGHT/2-64, ID.Player2)); for second player
		
		
	}
	//statrts up our thread
	public synchronized void start(){
	thread = new Thread(this);
	thread.start();
	running = true; //is thread on
	
	}
	//Stops the thread of the game
	public synchronized void stop(){
		try{
			thread.join();
			running = false; //is thread off
			
		}catch(Exception e)
		{
			e.printStackTrace(); //runs error bug through our console
		}
		
		}
	
	/*sets heartbeat of the game
	 allows the game to run
	 not my own code from the internet
	 very popular loop*/
	
	public void run()
	{
		this.requestFocus(); //do not need to clikc on screen to playe
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
				frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	//lowers the fps and renders objects in to the game
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs== null)
		{
			//creates three buffers in your game
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	//clamp 
	public static int clamp(int var, int min, int max) //var is the variable min and max are the bounds of the frame
	{
		if(var >= max)
		{ 
			return var = max;//never allows object to go outside the room used only for player
		}
		else if(var <= min)
		{
			return var = min;
		}
		else
		{
			return var;
		}
	}
	public static void main(String args[])
	{
		new Game();
	}
}
