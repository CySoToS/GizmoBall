package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.IGizmoController;
import model.Constants;

public class PlayBoard 
{
	private IGizmoController controller;
	private JPanel buttonPanel;
	private GamePanel gamePanel;
	private JPanel container;

	
	public PlayBoard(IGizmoController gizmoController)
	{
		this.controller = gizmoController;
		container = new JPanel(); //PlayView
		buttonPanel = new JPanel();
		gamePanel = new PlayPanel();
		gamePanel.setFocusable(true);
		gamePanel.grabFocus();
		createButtonPanel();
		createGamePanel();
		JSplitPane pane = new JSplitPane();
		pane.setLeftComponent(buttonPanel);
		pane.setRightComponent(gamePanel);
		container.add(pane);
		
	}
	private void createButtonPanel()
	{
		buttonPanel = new JPanel(new GridLayout(5,1));
		JButton playButton = new JButton("Start");
		playButton.addActionListener(controller.getPlayModeListener());
		playButton.setFocusable(false);
		JButton pauseButton = new JButton("Pause");
		pauseButton.addActionListener(controller.getPlayModeListener());
		pauseButton.setFocusable(false);
		JButton tickButton = new JButton("Tick");
		tickButton.addActionListener(controller.getPlayModeListener());
		tickButton.setFocusable(false);
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(controller.getPlayModeListener());
		resetButton.setFocusable(false);
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(controller.getPlayModeListener());
		quitButton.setFocusable(false);
		buttonPanel.add(playButton);
		buttonPanel.add(pauseButton);
		buttonPanel.add(tickButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(quitButton);
	}
	public JPanel getBoardView(){
		return container;
	}
	public void createGamePanel(){
		gamePanel.setPreferredSize(new Dimension(Constants.L*20, Constants.L*20));
	}
	public GamePanel getGamePanel(){
		return gamePanel;
	}
}
