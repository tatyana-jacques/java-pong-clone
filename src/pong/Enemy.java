package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public double x, y;
	int width, height;
	
	public Enemy (int x, int y) {
		this.x = x;
		this.y = y;
		width = 30;
		height = 5;
	}
	
	public void tick() {
		
			x+= (Game.ball.x - x) * 0.08;	
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
		
	}

}
