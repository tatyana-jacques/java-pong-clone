package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x, y;
	int width, height;
	public double dx,dy;
	public double speed = 1.9;
	public int angle;
	
	public Ball (int x, int y) {
		this.x = x;
		this.y = y;
		width = 5;
		height = 5;
		
		angle = new Random().nextInt(75) + 45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
		
	}
	
	public void tick() {
		
		if(x+ dx * speed + width >=Game.WIDTH) {
			dx *= -1;
			
		}
		else if(x+ dx * speed + width <0) {
			dx *= -1;
			
		}
		
		if(y>= Game.HEIGHT) {
			System.out.println("Ponto do inimigo");
			new Game();
			return;
			
		}else if ( y < 0) {
			System.out.println("Ponto do jogador!");
			new Game();
			return;
			
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y + (dy*speed)),width, height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.width, Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			angle = new Random().nextInt(75) + 45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy>0) {
				dy*=-1;
			}
			
		}
		else if(bounds.intersects(boundsEnemy)) {
			dy*=-1;
		}
	
		x += dx * speed;
		y += dy * speed;
			
	}
	
	public void render (Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, width, height);
		
	}

}
