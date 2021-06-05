package model;

import processing.core.PApplet;

public class Polo extends Thread
{
	PApplet app;
	
	float x1, y1;
	
	int rand;
	
	int wow;
	
	public Polo(PApplet app) 
	{
		x1 = app.random(75, 425);
		y1 = app.random(75, 425);
		
		rand = (int) app.random(0, 3);
		
		wow = 1;
	}
	
	public void run()
	{
		for(int i = 0; i > -1; i++)
		{
			try 
			{
				Polo.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			System.out.println("¡Polo! " + (int) x1 + ", " + (int) y1);
			
			wow *= -1;
		}
	}
	
	public void paint(PApplet app)
	{
		app.fill(0, 255, 0);
		app.circle(x1, y1, 50);
	}
	
	public void move(PApplet app)
	{
		switch(rand)
		{
		case 0:
			x1++;
			break;
		case 1:
			x1--;
			break;
		case 2:
			y1++;
			break;
		case 3:
			y1--;
			break;
		}
	}
	
	public void collisions(PApplet app)
	{
		if(x1 > 475)
		{
			x1 = 474;
			rand = 1;
		}
		
		if(x1 < 25)
		{
			x1 = 26;
			rand = 0;
		}
		
		if(y1 > 475)
		{
			y1 = 474;
			rand = 3;
		}
		
		if(y1 < 25)
		{
			y1 = 26;
			rand = 2;
		}
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public int getWow() {
		return wow;
	}

	public void setWow(int wow) {
		this.wow = wow;
	}
	
	

}
