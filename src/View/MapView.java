package view;

import model.IslandRule;
import model.Map;
import model.MapGenerator;
import model.RiverRule;

public class MapView {
	public static void main (String[] args){
		Map map = MapGenerator.makeEmptyMap(10,10);
		RiverRule rule = new RiverRule();
		
		map = rule.getRuling(map);		
		map.printMap();
	}
}
