package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.IModel;
import controller.GizmoController;
import controller.IGizmoController;
import controller.MagicKeyListener;


public class View implements IView, Observer{

	private JFrame frame;
	private BuildBoard buildBoard;
	private PlayBoard playBoard;
	
	private IGizmoController controller;
	private IModel model;
	
	public View(IModel m) {
		model = m;
		model.addObserver(this);
		controller = new GizmoController(this, model);
		createMainFrame();
		setListeners();
	}
	
	private void createMainFrame() {
		frame = new JFrame();
		createMenuBar();
		buildBoard = new BuildBoard();
		playBoard = new PlayBoard(controller);
		buildBoard.setVisibility(true);
	    buildBoard.getGamePanel().setModel(model);
	    playBoard.getGamePanel().setModel(model);	    
	    frame.add(buildBoard.getBoardView());
		frame.pack();
		frame.setVisible(true);
		buildBoard.getGravitySlider().addChangeListener(controller.getGravitySliderListener());
		buildBoard.getFrictionSlider().addChangeListener(controller.getFrictionSliderListener());
		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu standartMenu = new JMenu("Menu");
		JMenuItem menuLoadItem = new JMenuItem("Load");
		JMenuItem menuSaveItem = new JMenuItem("Save");
		JMenuItem menuToggleItem = new JMenuItem("Toggle");
		JMenuItem menuExitItem = new JMenuItem("Exit");
		
		standartMenu.add(menuLoadItem);
		standartMenu.add(menuSaveItem);
		standartMenu.add(menuToggleItem);
		standartMenu.add(menuExitItem);
		menuExitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		menuSaveItem.addActionListener(controller.getSaveListener());
		menuLoadItem.addActionListener(controller.getLoadListener());
		menuToggleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				frame = new JFrame();
				if(buildBoard.isVisible()){
					buildBoard.setVisibility(false);
					frame.add(playBoard.getBoardView());
					playBoard.getGamePanel().repaint();
					playBoard.getGamePanel().addKeyListener(new MagicKeyListener(controller.getRunKeyListener()));
				}
				else
				{
					model.resetBall();
					buildBoard.setVisibility(true);
					frame.add(buildBoard.getBoardView());
					if(model.getBall()!=null)
						model.getBall().stop();
					buildBoard.getGamePanel().repaint();
				}
				frame.pack();
				frame.setVisible(true);
				frame.setJMenuBar(menuBar);
			}
		});
		
		menuBar.add(standartMenu);
		frame.setJMenuBar(menuBar);
	}
	
	private void setListeners() {
		buildBoard.getGamePanel().addMouseListener(controller.getGridPanelListener());
	}

	@Override
	public JPanel getGridPanel() {
		return buildBoard.getGamePanel();
	}

	@Override
	public String getSelectedAction() {
		if(buildBoard.getBGroup().getSelection() == null)
			return "No action";
		return buildBoard.getBGroup().getSelection().getActionCommand();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		buildBoard.getGamePanel().repaint();
		playBoard.getGamePanel().repaint();
	}

	@Override
	public JComboBox getTriggerAction() {
		return buildBoard.getTriggerAction();
	}

	@Override
	public JSlider getGravitySlider() {
		return buildBoard.getGravitySlider();
	}

	@Override
	public JSlider getFrictionSlider() {
		return buildBoard.getFrictionSlider();
	}
	

}
