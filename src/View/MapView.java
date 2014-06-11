package view;

import java.awt.Graphics;

import model.IslandRule;
import model.Map;
import model.MapGenerator;
import model.RiverRule;

public class MapView {
	public Map getMap(String[] args) {
		Map map = MapGenerator.makeEmptyMap(10, 10);
		RiverRule rule = new RiverRule();

		map = rule.getRuling(map);
		return map;
	}

	public void printMap(Map theMap) {
		// theMap.printMap();

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
				} else if (theMap.getTile(i, j).getSaturation() == 0) {
					System.out.print(" l |");
				} else if (theMap.getTile(i, j).getSaturation() == 0
						&& theMap.getTile(i, j).getElevation() > 0) {
					System.out.print(" e |");
				} else if (theMap.getTile(i, j).getSaturation() == 50) {
					System.out.print(" r |");
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
