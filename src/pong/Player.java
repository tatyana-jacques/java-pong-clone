package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right, left;
	public int x, y, width, height, speed;
	
	
	public Player (int x, int y) {
		this.x = x;
		this.y = y;
		width = 30;
		height = 5;
		speed = 2;
	}
	
	public void tick() {
		if(right && x+width < Game.WIDTH) {
			x+=speed;
		}
		else if (left && x > 0) {
			x-=speed;
		}
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		
	}

}
