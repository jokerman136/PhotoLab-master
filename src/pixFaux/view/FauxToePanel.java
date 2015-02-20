package pixFaux.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import pixFaux.controller.FauxToeController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;


public class FauxToePanel extends JPanel
{
	private JComboBox<String> filterBox;
	private JComboBox<String> imageBox;
	private JScrollPane imagePane;
	private SpringLayout baseLayout;
	private String [] imageArray;
	private Picture basePicture;
	
	private FauxToePanel(FauxToeController baseController)
	{
		this.baseController = baseController;
		
		imagePane = new JScrollPane();
		basePicture = new Picture("beach.jpg");
		baseLayout = new SpringLayout();
		
		
		setupPicture();
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] 
	}
	
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(filterBox);
		this.add(imagePane);
	}

	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
	}
	
	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}
	
	private void setupListeners()
	{
		// TODO Auto-generated method stub
		
	}

}
