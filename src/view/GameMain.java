package view;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;

public class GameMain extends Applet implements Runnable {

	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.CYAN);
		setFocusable(true);
		
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Example");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
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
	 * contains the main game loop to be threaded
	 */
	@Override
	public void run() {
		while(true){
			// main game loop
			
			try{
				Thread.sleep(17);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
