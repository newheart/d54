package edu.mit.d54.plugins.test;

import edu.mit.d54.Display2D;
import edu.mit.d54.DisplayPlugin;

/**
 * This is an example plugin which will render a moving color spectrum on the display.
 */
public class TestPlugin extends DisplayPlugin
{
	private final double dt;
	
	public TestPlugin(Display2D display, double framerate) {
		super(display, framerate);
		dt=1./framerate;
	}

	private double time=0;
	@Override
	protected void loop() {
		Display2D display=getDisplay();
		time+=dt;
		for (int x=0; x<display.getWidth(); x++)
		{
			for (int y=0; y<display.getHeight(); y++)
			{
				display.setPixelHSB(x,y,(float)(x+y+time*3)/36.f, 1f, 1f);
			}
		}
	}
	
}