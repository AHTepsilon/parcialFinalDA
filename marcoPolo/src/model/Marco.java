package model;

import processing.core.PApplet;

public class Marco extends Thread
{
	PApplet app;
	
	float x1, y1;
	
	int wow;
	
	int rand;
	
	public Marco(PApplet app)
	{
		x1 = 250;
		y1 = 250;
		
		rand = (int) app.random(0, 3);
		
		wow = 1;
	}
	
	public void run()
	{
		for(int i = 0; i > -1; i++)
		{
			System.out.println("¡Marco!");
	
			try 
			{
				Marco.sleep(2000);
			}
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			wow *= -1;
		}
	}
	
	public void text(PApplet app)
	{
		app.fill(255);
		app.text("¡Marco!", x1, y1);
	}
	
	public void paint(PApplet app)
	{
		app.fill(255, 0, 0);
		app.circle(x1, y1, 50);
	}
	
	public void move(PApplet app)
	{
		switch(rand)
		{
		case 0:
			x1 += 5;
			break;
		case 1:
			x1 -= 5;
			break;
		case 2:
			y1 += 5;
			break;
		case 3:
			y1 -= 5;
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
	
	public int getWow() {
		return wow;
	}
	
	public void setWow(int wow) {
		this.wow = wow;
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
	
	public int getRand() {
		return rand;
	}
	
	public void setRand(int rand) {
		this.rand = rand;
	}
	
	
}
