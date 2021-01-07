 package random_balls;
 
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Dimension;
 import java.util.Random;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.util.ArrayList;
 import random_balls.Ball;
 
 public class RandomBalls extends JFrame {

	final String TITLE_OF_PROGRAM = "Random Balls";
	final int WINDOW_WIDTH = 650;
	final int WINDOW_HEIGHT = 650;
	final Color[] COLORS = {Color.red, Color.green, Color.blue};
	final int COUNT_BALLS = 100;
	
	int showDelay = 1000;
	int counter = 0;
	Random random;
	ArrayList<Ball> balls;
	Canvas canvas;

/* 	public static void main(String[] args) {
		new RandomBalls().game();
	} */
	 
	public RandomBalls() {
		random = new Random();
		balls = new ArrayList<>();
		
		setTitle(TITLE_OF_PROGRAM);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		canvas = new Canvas();
		canvas.setBackground(Color.white);
		canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				deleteBall(e.getX(), e.getY());
				canvas.repaint();
			}
		});

		add(canvas);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	void addBall() {
		int d = random.nextInt(20) + 60;
		int x = random.nextInt(WINDOW_WIDTH - d);
		int y = random.nextInt(WINDOW_HEIGHT - d);
		Color color = COLORS[random.nextInt(COLORS.length)];
		balls.add(new Ball(x, y, d, color));
	}
	
	void deleteBall(int x, int y) {
		for (int i = balls.size() - 1; i > -1; i--) {
			double dx = balls.get(i).x + balls.get(i).d/2 - x;
			double dy = balls.get(i).y  + balls.get(i).d/2 - y;
			double d = Math.sqrt(dx * dx + dy * dy);
			if (d < balls.get(i).d/2) {
				balls.remove(i);
				break;
			}
		}
	}
	
	public void game() {
		while (true) {
			addBall();
			if (balls.size() >= 5) {
				System.out.println("Game Over: " + counter);
				break;
			}
			canvas.repaint();
			counter++;
			if (counter % 10 == 0 && showDelay > 100) {
				showDelay -= 100;
			}
			try {
				Thread.sleep(showDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Canvas extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			// рисуем окружности
			for (Ball ball : balls) {
				ball.paint(g);
			}
		}
	}
	 
 }