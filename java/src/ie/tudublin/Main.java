package ie.tudublin;

import C21416084.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YofukaVisuals());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}