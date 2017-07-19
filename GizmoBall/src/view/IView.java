package view;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;

public interface IView {

	public JPanel getGridPanel();
	public String getSelectedAction();
	public JComboBox getTriggerAction();
	public JSlider getGravitySlider();
	public JSlider getFrictionSlider();
}
