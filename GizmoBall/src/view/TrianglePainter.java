package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class TrianglePainter implements IGizmoPainter{

	private Point[] points;
	private Color c;
	
	public TrianglePainter(List<Point> p) {
		points = new Point[3];
		points = p.toArray(new Point[0]);
		c = Color.BLACK;
	}
	
	@Override
	public void paint(Graphics g) {
		int[] x = new int[3];
		int[] y = new int[3];
		
		for(int i=0; i<3; i++) {
			x[i] = (int)points[i].getX();
			y[i] = (int)points[i].getY();
		}
		
		g.setColor(c);
		g.fillPolygon(x, y, 3);
	}

	@Override
	public void setColor(Color c) {
		this.c = c;
	}

}
