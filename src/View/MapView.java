package View;

import Model.IslandRule;
import Model.Map;
import Model.MapGenerator;
import Model.RiverRule;
import Model.Rule;
import Model.Tile;
import Controller.*;

import java.util.Random;

public class MapView {
	public static void main (String[] args){
		Map map = MapGenerator.makeEmptyMap(6, 6);
		RiverRule rule = new RiverRule();
		
		map = rule.getRuling(map);		
		map.printMap();
	}
}
