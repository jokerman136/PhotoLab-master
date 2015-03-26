package pixFaux.view;

import javax.swing.JFrame;

import pixFaux.controller.FauxToeController;

public class FauxToeFrame
{
	private FauxToePanel basePanel;
	
	public FauxToeFrame(FauxToeController baseController)
	{
		basePanel = new FauxToePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(450, 450);
		this.setContentPane(basePanel);
		this.setVisible(true);
		this.setResizable(true);
	}
}