package random_balls;

import java.awt.Color;
import java.awt.Graphics;
 
public class Ball {
	int x, y, d;
	Color color;
	
	public Ball(int x, int y, int d, Color color) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.color = color;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, d, d);
		g.setColor(Color.black);
		g.drawOval(x, y, d, d);
	}
 
}