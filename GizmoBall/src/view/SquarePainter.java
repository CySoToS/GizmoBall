package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import model.Constants;

public class SquarePainter implements IGizmoPainter{

	private Point[] points;
	private Color c;
	
	public SquarePainter(List<Point> p) {
		points = new Point[4];
		points = p.toArray(new Point[0]);
		c = Color.BLACK;
	}
	
	@Override
	public void paint(Graphics g) {
		int[] x = new int[4];
		int[] y = new int[4];
		
		for(int i=0; i<4; i++) {
			x[i] = (int)points[i].getX();
			y[i] = (int)points[i].getY();
		}
		
		g.setColor(c);
		g.fillRect(x[0], y[0], Constants.L, Constants.L);
	}

	@Override
	public void setColor(Color c) {
		this.c = c;
	}

}
