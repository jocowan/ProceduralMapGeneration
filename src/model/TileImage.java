package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public abstract class TileImage extends Image {

	@Override
	public abstract Graphics getGraphics();

	@Override
	public abstract int getHeight(ImageObserver observer);

	@Override
	public abstract Object getProperty(String name, ImageObserver observer);

	@Override
	public abstract ImageProducer getSource();

	@Override
	public abstract int getWidth(ImageObserver observer);

}
