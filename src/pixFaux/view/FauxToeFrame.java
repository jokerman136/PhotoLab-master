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

	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setContentPane(FauxToePanel basePanel2) {
		// TODO Auto-generated method stub
		
	}

	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}