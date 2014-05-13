package View;

import Model.IslandRule;
import Model.Map;
import Model.MapGenerator;
import Model.Rule;
import Model.Tile;
import Controller.*;
import java.util.Random;

public class MapView {
	public static void main (String[] args){
		Map islandMap = MapGenerator.makeEmptyMap(6, 6);
		IslandRule rule = new IslandRule();
		
		islandMap = rule.getRuling(islandMap);
		
		Random randomGenerator = new Random();
		int randX = randomGenerator.nextInt(islandMap.getLengthX());
		int randY = randomGenerator.nextInt(islandMap.getLengthY());
		
		while (islandMap.getTile(randX, randY).getSaturation() != 0){
			randX = randomGenerator.nextInt(islandMap.getLengthX());
			randY = randomGenerator.nextInt(islandMap.getLengthY());
		}
		
		islandMap.printMap();
	}
}
