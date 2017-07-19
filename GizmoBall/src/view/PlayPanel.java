package view;

import java.awt.Graphics;

public class PlayPanel extends GamePanel
{
	public PlayPanel()
	{
		super();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.paintGizmos(g);
	}
}
