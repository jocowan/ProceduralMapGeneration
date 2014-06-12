package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.applet.Applet;

import model.IslandRule;
import model.Map;
import model.MapGenerator;
import model.RiverRule;

public class MapView {
	
	public static Map getMap(String[] args) {
		Map map = MapGenerator.makeEmptyMap(10, 10);
		RiverRule rule = new RiverRule();

		map = rule.getRuling(map);
		return map;
	}

	public static void printMap(Map theMap, Graphics theGraphics, ImageObserver theObserver) {
		
		Image waterTile = Toolkit.getDefaultToolkit().getImage("../resources/grass_tile.png");
		Image grassTile = Toolkit.getDefaultToolkit().getImage("../resources/grass_tile.png");
		// theMap.printMap();
		
		theGraphics.drawString("help", 0, 0);
		
		System.out.println(grassTile.toString());

		int lengthX = theMap.getLengthX();
		int lengthY = theMap.getLengthY();

		int i = 0;
		int j = 0;

		System.out.print("+");
		for (i = 0; i < lengthX; i++) {
			System.out.print(" - +");
		}
		for (i = 0; i < lengthX; i++) {
			System.out.print("\n");
			System.out.print("|");
			for (j = 0; j < lengthY; j++) {
				if (theMap.getTile(i, j).getSaturation() == 100) {
					System.out.print(" w |");
					
					theGraphics.drawImage(waterTile, i+64, j+64, theObserver);
					
				} else if (theMap.getTile(i, j).getSaturation() == 0) {
					System.out.print(" l |");
					
					theGraphics.drawImage(grassTile, i+64, j+64, theObserver);
				} else if (theMap.getTile(i, j).getSaturation() == 0
						&& theMap.getTile(i, j).getElevation() > 0) {
					System.out.print(" e |");
				} else if (theMap.getTile(i, j).getSaturation() == 50) {
					System.out.print(" r |");
					
					theGraphics.drawImage(waterTile, i+64, j+64, theObserver);
				} else {
					System.out.print(" ? |");
				}
			}
		}
		
		System.out.print("\n");
		System.out.print("+");
		for (i = 0; i < lengthX; i++){
			System.out.print(" - +");
		}
		System.out.print("\n");
	}

}
