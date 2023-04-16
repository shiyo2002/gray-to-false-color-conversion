// Java program to demonstrate
// colored to grayscale conversion

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class chintana {
	public static void main(String args[])
		throws IOException
	{
		BufferedImage img = null;
		File f = null;

		// read image
		try {
			f = new File(
				"C:\\Users\\shivam barua\\Pictures/kavet.jpg");
			img = ImageIO.read(f);
		}
		catch (IOException e) {
			System.out.println(e);
		}

		// get image's width and height
		int width = img.getWidth();
		int height = img.getHeight();

		// convert to false sclae
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				// Here (x,y)denotes the coordinate of image
				// for modifying the pixel value.
				int p = img.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;

				// calculate average
				int avg = (r + g + b) / 3;
                 r = 200;
				 g = 300;
				 b = 3*avg-r-g;

				// replace gray value with RGB
				p = (a << 24) | (r << 16) | (g << 8)
					| b;

				img.setRGB(x, y, p);
			}
		}

		// write image
		try {
			f = new File(
				"C:\\Users\\shivam barua\\Pictures/kavet_1.jpg");
			ImageIO.write(img, "jpg", f);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}

   //"C:\\Users\\shivam barua\\Pictures\\pp.jpg"
   //
 