package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.IslandRule;
import model.Map;
import model.MapGenerator;

public class MapView {

	/**
	 * 
	 * getMap takes a string of formating arguments to be passed to the rule
	 * objects which will modify the outputed map. It will return a generated
	 * map with the provided rules, and arguments applied
	 * 
	 * @param args
	 * @return
	 */
	public static Map getMap(String[] args) {
		// TODO implement arguments
		Map map = MapGenerator.makeEmptyMap(10, 10);
		IslandRule rule = new IslandRule();

		map = rule.getRuling(map, null);
		return map;
	}

	/**
	 * Draws the map to the graphics output object. Takes a map, the graphics
	 * object, and the image observer as arguments.
	 * 
	 * @param theMap
	 * @param theGraphics
	 * @param theObserver
	 */
	public static void printMap(Map theMap, Graphics theGraphics,
			ImageObserver theObserver) {
		BufferedImage waterTile = getWaterTile();
		BufferedImage grassTile = getGrassTile();

		int lengthX = theMap.getLengthX();
		int lengthY = theMap.getLengthY();

		int i = 0;
		int j = 0;

		System.out.print("+");
		for (i = 0; i < lengthX; i++) {
			System.out.print(" - +");
		}

		// iterate through the map and print out each tile as needed
		for (i = 0; i < lengthX; i++) {
			System.out.print("\n");
			System.out.print("|");
			for (j = 0; j < lengthY; j++) {
				if (theMap.getTile(i, j).getSaturation() == 100) {
					System.out.print(" w |");

					theGraphics.drawImage(waterTile, i * 64, j * 64,
							theObserver);

					// if the tile corresponds to grass
				} else if (theMap.getTile(i, j).getSaturation() == 0) {
					System.out.print(" l |");
					theGraphics.drawImage(grassTile, i * 64, j * 64,
							theObserver);

					// if the tile corresponds to a hill
				} else if (theMap.getTile(i, j).getSaturation() == 0
						&& theMap.getTile(i, j).getElevation() > 0) {
					System.out.print(" e |");

					// if the tile corresponds to a river
				} else if (theMap.getTile(i, j).getSaturation() == 50) {
					System.out.print(" r |");

					theGraphics.drawImage(waterTile, i * 64, j * 64,
							theObserver);
				} else {
					System.out.print(" ? |");
				}
			}
		}

		System.out.print("\n");
		System.out.print("+");
		for (i = 0; i < lengthX; i++) {
			System.out.print(" - +");
		}
		System.out.print("\n");
	}

	/**
	 * gets the water tile image to be draw to the screen
	 * 
	 * @return
	 */
	private static BufferedImage getWaterTile() {

		BufferedImage waterTile = null;
		try {
			waterTile = ImageIO.read(new File(System.getProperty("user.dir")
					+ "\\..\\resources\\water_tile.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return waterTile;
	}

	/**
	 * gets the grass tile object to be draw to the screen
	 * 
	 * @return
	 */
	private static BufferedImage getGrassTile() {
		BufferedImage grassTile = null;
		try {
			grassTile = ImageIO.read(new File(System.getProperty("user.dir")
					+ "\\..\\resources\\grass_tile.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grassTile;
	}
}
