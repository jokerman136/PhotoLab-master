package pixLab.classes;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester
{
	
	public static void testMirrorVerticalRightToLeft()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.mirrorVerticalRightToLeft();
	    caterpillar.explore();
	}
	
	public static void testMirrorHorizontal()
	{
	    Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.mirrorHorizontal();
	    caterpillar.explore();
	}
	
	public static void testMirrorHorizontalBottomToTop()
	{
	    Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.mirrorHorizontalBottomToTop();
	    caterpillar.explore();
	}
	
	public static void testMirrorDiagonal()
	{
	    Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorDiagonal();
	    caterpillar.explore();
	}

	public static void testMirrorArms()
	{
	    Picture snowman = new Picture("snowman.jpg");
	    snowman.explore();
	    snowman.mirrorArms();
	    snowman.explore();
	}
	
	public static void testMirrorGull()
	{
	    Picture seagull = new Picture("seagull.jpg");
	    seagull.explore();
	    seagull.mirrorGull();
	    seagull.explore();
	}
	
	public static void testFixUnderwater()
	{
		Picture water = new Picture("water.jpg");
		water.explore();
		water.fixUnderwater();
		water.explore();
	}
	
	public static void testGrayscale()
	{
		Picture beach = new Picture("beach.jpg");
		beach.grayscale();
		beach.explore();
	}
	
	public static void testNegate()
	{
		Picture beach = new Picture("beach.jpg");
		beach.negate();
		beach.explore();
	}
	
	public static void testKeepOnlyGreen()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyGreen();
		beach.explore();
	}
	
	public static void testKeepOnlyRed()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyRed();
		beach.explore();
	}
	
	public static void testKeepOnlyBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyBlue();
		beach.explore();
	}
	
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}
	
	public static void testRandomChange()
	{
		Picture temple = new Picture();
		temple.explore();
		temple.randomChange();
		temple.explore();
	}
	
	public static void testSepiaTone()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.sepiaTone();
		beach.explore();
	}
	

	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}
	
	public static void testCopy()
	{
	    Picture canvas = new Picture("640x480.jpg");
	    canvas.createCollage();
	    canvas.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args)
	{
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		testNegate();
		testGrayscale();
		testFixUnderwater();
		testMirrorVertical();
		testMirrorVerticalRightToLeft();
		testMirrorTemple();
		testMirrorArms();
		testMirrorGull();
		testMirrorDiagonal();
		testMirrorHorizontalBottomToTop();
		testMirrorHorizontal();
		// testCollage();
		testCopy();
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
		testSepiaTone();
		testRandomChange();
	}
}