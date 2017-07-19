package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import model.Constants;

public class LeftFlipperPainter implements IGizmoPainter{

	private Point[] points;
	private Color c;
	
	public LeftFlipperPainter (List<Point> p) {
		points = new Point[6];
		points = p.toArray(new Point[0]);
		c = Color.BLACK;
	}
	
	@Override
	public void paint(Graphics g) {
		int[] x = new int[6];
		int[] y = new int[6];
		
		for(int i=0; i<6; i++) {
			x[i] = (int)points[i].getX();
			y[i] = (int)points[i].getY();
		}
		g.setColor(c);
		g.fillOval(x[0] - Constants.L/4, y[0] - Constants.L/4, Constants.L/2, Constants.L/2);
		g.fillOval(x[1] - Constants.L/4, y[1] - Constants.L/4, Constants.L/2, Constants.L/2);

		int[] rectXPoints = Arrays.copyOfRange(x, 2, 6);
		int[] rectYPoints = Arrays.copyOfRange(y, 2, 6);

		g.fillPolygon(rectXPoints, rectYPoints, 4);
		
	}

	@Override
	public void setColor(Color c) {
		this.c = c;
	}

}
