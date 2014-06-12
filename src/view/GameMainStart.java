package view;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import model.Map;

public class GameMainStart extends Applet implements Runnable {

	/**
	 * double buffering system to allow for continuous updates at 60fps
	 */
	private static final long serialVersionUID = -7572571961634325708L;
	private Image backbuffer;
	private Graphics backg;
	private Map theNewMap;

	int width, height;

	@Override
	public void init() {				
		width = 800;
		height = 800;

		setSize(width, height);

		backbuffer = createImage(width, height);
		

		backg = backbuffer.getGraphics();


		// setFocusable(true);

		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Map View Alpha");

		theNewMap = MapView.getMap(null);
		MapView.printMap(theNewMap, backg, this);
	}

	@Override
	public void start() {
		Thread mainThread = new Thread(this);
		mainThread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * main game run method
	 * main game loop that updates all the elements
	 */
	@Override
	public void run() {
		while (true) {
			// main game loop
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Graphics g) {

		g.drawImage(backbuffer, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
	}

}
