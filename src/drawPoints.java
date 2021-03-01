import processing.core.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class drawPoints extends PApplet {

	public void settings()
	{	size(500, 500);
	}
  
	public void setup()
	{
    	background(180);
    	noLoop();
  	}

  	public void draw() {

   	double x, y, z;
   
   	String[] lines = loadStrings("drawMe.txt");

   	println("there are " + lines.length);
  		for (int i=0; i < lines.length; i++)
  		{
			if (lines[i].length() > 0 )
			{
					String[] words= lines[i].split(",");
					x = Double.parseDouble(words[0]);
					y = Double.parseDouble(words[1]);
					z = Double.parseDouble(words[2]);

//					println("xy: " + x + " " + y + " " + z);
					ellipse((int)x, (int)y, 1, 1);
			}
  		}
  	}

  	public static void main(String args[])
	{
		try { new Filter(); }
		catch (IOException e) { e.printStackTrace(); }

		PApplet.main("drawPoints");
	}
}
