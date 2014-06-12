package view;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.URL;

import model.Map;

public class GameMainStart extends Applet implements Runnable {

	private Image backbuffer;
	private Graphics backg;
	private URL base;
	private Map theNewMap;

	int width, height;

	@Override
	public void init() {
		width = getSize().width;
		height = getSize().height;

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
	 * main game run method contains the main game loop to be threaded
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
		MapView.printMap(theNewMap, g, this);
	}

}
