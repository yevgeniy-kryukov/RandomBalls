package random_balls;

import java.awt.Color;
import java.awt.Graphics;
 
class Ball {
	private int x;
	private int y;
	private int d;
	private Color color;
	
	Ball(int x, int y, int d, Color color) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.color = color;
	}
	
	void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, d, d);
		g.setColor(Color.black);
		g.drawOval(x, y, d, d);
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	} 

	int getD() {
		return d;
	} 
}