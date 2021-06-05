package view;
import java.util.ArrayList;

import model.Marco;
import model.Polo;
import processing.core.PApplet;

public class World extends PApplet
{

	public static void main(String[] args) 
	{
		PApplet.main("view.World");
	}
	
	@Override
	public void settings() //void Awake
	{
		size(500, 500);
	}
	
	Marco marco;
	
	Thread world;
	
	ArrayList<Polo> poloList;
	
	@Override
	public void setup() //void Start
	{	
		poloList = new ArrayList<Polo>();
		
		for(int i = 1; i <= 20; i++)
		{
			poloList.add(new Polo(this));
		}
		
		for(int i = 0; i < poloList.size(); i++)
		{
			poloList.get(i).start();
		}
		
		marco = new Marco(this);
		
		marco.start();
		
	}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		textAlign(CENTER);
		
		noStroke();
		
		marco.paint(this);
		
		marco.move(this);
		
		marco.collisions(this);
		for(int i = 0; i < poloList.size(); i++)
		{
			poloList.get(i).paint(this);
			poloList.get(i).move(this);
			poloList.get(i).collisions(this);
		}
		
		if(marco.getWow() == 1)
		{
			fill(0);
			text("¡Marco!", marco.getX1(), marco.getY1());
		}
		
		for(int i = 0; i < poloList.size(); i++)
		{
			fill(0);
			Polo actual = poloList.get(i);
			
			if(actual.getWow() == -1)
			{
				textSize(10);
				text("¡Polo!" + (int)actual.getX1() + ", " + (int)actual.getY1(), actual.getX1(), actual.getY1());
			}
		}
		
		chase();
		delete();
	}
	
	public void chase()
	{
		System.out.println(marco.getRand());
		for(int i = 0; i < poloList.size(); i++)
		{
			Polo actual = poloList.get(i);
			
			if((marco.getRand() == 3 || marco.getRand() == 2) && (marco.getY1() == actual.getY1()))
			{
				if(marco.getX1() < actual.getX1())
				{
					marco.setRand(0);
				}
				else if(marco.getX1() > actual.getX1())
				{
					marco.setRand(1);
				}
			}
			
			else if((marco.getRand() == 0 || marco.getRand() == 1) && (marco.getX1() == actual.getX1()))
			{
				if(marco.getY1() < actual.getY1())
				{
					marco.setRand(2);
				}
				else if(marco.getY1() > actual.getY1())
				{
					marco.setRand(3);
				}
			}
		}
	}
	
	public void delete()
	{
		for(int i = 0; i < poloList.size(); i++)
		{
			Polo actual = poloList.get(i);
			
			if(dist(marco.getX1(), marco.getY1(), actual.getX1(), actual.getY1()) < 40)
			{
				poloList.remove(i);
			}
		}
	}

}

