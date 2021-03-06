package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */

	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());
			}
		}
	}

	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
				pixelObj.setBlue((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
				pixelObj.setGreen((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
			}
		}
	}

	public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();

		int rAvg = 0;
		int gAvg = 0;
		int bAvg = 0;
		int totalPixels = 0;

		int maxR = 0;
		int minR = 255;
		int maxG = 0;
		int minG = 255;
		int maxB = 0;
		int minB = 255;

		// takes a sample from a fish and finds the average color value and
		// range of colors
		for (int row = 26; row < 36; row++)
		{
			for (int col = 178; col < 198; col++)
			{
				totalPixels++;

				Pixel pixel = pixels[row][col];

				rAvg += pixel.getRed();
				gAvg += pixel.getGreen();
				bAvg += pixel.getBlue();

				if (pixel.getRed() > maxR)
				{
					maxR = pixel.getRed();
				}

				if (pixel.getRed() < minR)
				{
					minR = pixel.getRed();
				}
				if (pixel.getGreen() > maxG)
				{
					maxG = pixel.getGreen();
				}
				if (pixel.getGreen() < minG)
				{
					minG = pixel.getGreen();
				}
				if (pixel.getBlue() > maxB)
				{
					maxB = pixel.getBlue();
				}
				if (pixel.getGreen() < minB)
				{
					minB = pixel.getBlue();
				}

			}
		}

		rAvg = rAvg / totalPixels;
		gAvg = gAvg / totalPixels;
		bAvg = bAvg / totalPixels;

		Color averageColor = new Color(rAvg, gAvg, bAvg);

		int rRng = (maxR - minR);
		int gRng = (maxG - minG);
		int bRng = (maxB - minB);

		int rDis = rRng;
		int gDis = gRng;
		int bDis = bRng;

		double maxDistance = Math.sqrt(rDis * rDis + gDis * gDis + bDis * bDis);

		double tol = 1.7;

		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				Pixel myPixel = pixels[row][col];

				boolean close = myPixel.colorDistance(averageColor) < maxDistance * tol;
				if (close)
				{
					myPixel.setBlue(myPixel.getBlue() + 50);
				}
				else
				{
					myPixel.setBlue(myPixel.getBlue() - 50);
				}
			}
		}
	}

	public void mirrorVerticalRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width / 2; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	    }
	}

	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
	      Pixel topPixel = null;
	      Pixel botPixel = null;
	      int height = pixels.length;
	      for (int row = 0; row < height; row++)
	      {
	          for (int col = 0; col < pixels[0].length; col++)
	          {
	              topPixel = pixels[row][col];
	              botPixel = pixels[height - 1 - row][col];
	              botPixel.setColor(topPixel.getColor());
	          }
	      }
	}
	
	public void mirrorHorizontalBottomToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
	      Pixel topPixel = null;
	      Pixel botPixel = null;
	      int height = pixels.length;
	      for (int row = 0; row < height; row++)
	      {
	          for (int col = 0; col < pixels[0].length; col++)
	          {
	              topPixel = pixels[row][col];
	              botPixel = pixels[height - 1 - row][col];
	              topPixel.setColor(botPixel.getColor());
	          }
	      }
	}
	
	public void mirrorGull()
	{
		int mirrorPoint = 345;
	    Pixel rightPixel = null;
	    Pixel leftPixel = null;
	    Pixel[][] pixels = this.getPixels2D();   
	    
	    for (int row = 235; row < 323; row++)
	    {
	      for (int col = 238; col < mirrorPoint; col++)
	      {
	        rightPixel = pixels[row][col];      
	        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	    }
	}
	
	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
	      Pixel topRightPixel = null;
	      Pixel bottomLeftPixel = null;
	      int maxLength;
	      if (pixels.length < pixels[0].length) 
	      { 
	    	  maxLength = pixels.length; 
	      }
	      else 
	      {
	    	  maxLength = pixels[0].length; 
	      }
	      
	      for (int row = 0; row < maxLength; row++)
	      {
	          for (int col = row; col < maxLength; col++)
	          {
	              topRightPixel = pixels[row][col];
	              bottomLeftPixel = pixels[col][row];
	              bottomLeftPixel.setColor(topRightPixel.getColor());
	          }
	      }
	}
	
	public void keepOnlyRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setRed(0);
			}
		}
	}

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setRed(0);
			}
		}
	}

	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void sepiaTone()
	{
		Pixel[][] imageMatrix = this.getPixels2D();
		for (int row = 0; row < imageMatrix.length; row++)
		{
			for (int col = 0; col < imageMatrix[0].length; col++)
			{
				// Pseudocode
				/**
				 * change pixel to a sepia tint of brown to white (112, 66, 20)
				 * dark sepia to (255, 255, 255) first Alg: Cut the red to fit
				 * between 112-255 shift green to half of Red Shift Blue to a
				 * third of Green
				 */
				Pixel sepiaPixel = imageMatrix[row][col];
				int averageColor = (sepiaPixel.getRed() + sepiaPixel.getBlue() + sepiaPixel.getGreen()) / 3;
				if (averageColor < 80)
				{
					sepiaPixel.setGreen(sepiaPixel.getRed() / 2);
					sepiaPixel.setBlue(sepiaPixel.getGreen() / 4);
				}
				else
				{
					// (255, 204, 51) Wheatish color
					sepiaPixel.setRed((int) (sepiaPixel.getRed() * .9));
					sepiaPixel.setGreen((int) (sepiaPixel.getRed() * .8));
					sepiaPixel.setBlue((int) (sepiaPixel.getRed() * .4));
				}

			}
		}
	}

	public void mirrorArms()
	{
		int mirrorPoint = 193;
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    Pixel[][] pixels = this.getPixels2D();

	    for (int row = 158; row < mirrorPoint; row++)
	    {
	      for (int col = 103; col < 170; col++)
	      {
	        topPixel = pixels[row][col];      
	        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	        bottomPixel.setColor(topPixel.getColor());
	      }
	    }
	}
	
	public void randomChange()
	{
		Pixel[][] imageMatrix = this.getPixels2D();
		for (int row = 0; row < imageMatrix.length; row += 2)
		{
			for (int col = 0; col < imageMatrix[0].length; col++)
			{
				int randomRed = (int) (Math.random() * 256);
				int randomGreen = (int) (Math.random() * 256);
				int randomBlue = (int) (Math.random() * 256);
				imageMatrix[row][col].setRed(randomRed);
				imageMatrix[row][col].setGreen(randomGreen);
				imageMatrix[row][col].setBlue(randomBlue);
			}
		}
	}

	public void mirrorTemple()
	{
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 27; row < 97; row++)
		{
			for (int col = 13; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args)
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
