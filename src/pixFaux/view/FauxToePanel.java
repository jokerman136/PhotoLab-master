package pixFaux.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

import pixFaux.controller.FauxToeController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;


public class FauxToePanel extends JPanel
{
	private FauxToeController baseController;
	private JComboBox<String> filterBox;
	private JComboBox<String> imageBox;
	private JScrollPane imagePane;
	private SpringLayout baseLayout;
	private String [] imageArray;
	private Picture basePicture;
	
	
	FauxToePanel(FauxToeController baseController)
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
		String [] filterArray =
			{
				"TestRandom Change",
				"Test Zero Blue",
				"Test Copy",
				"Tes",
				"",
				"",
				"",
				"",
				"",
				""
			};
		filterBox = new JComboBox(filterArray);
		
		imageArray = new String []
			{
				"",
				"",
				"",
				"",
				"",
				""
			};
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
	
	private void loadPic()
	{
		basePicture = new Picture (imageArray[imageBox.getSelectedIndex()]);
		setupPicture();
	}
	
	private void setupLayout()
	{

		
	}
	
	private void setupListeners()
	{
		imageBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
				if(filterBox.getSelectedIndex()==0)
				{
					loadPic();
					basePicture.randomChange();
					setupPicture();
				}
			}
		});
		
	}

}
