package view;

import model.IslandRule;
import model.Map;
import model.MapGenerator;

public class MapView {
	public static void main (String[] args){
		Map map = MapGenerator.makeEmptyMap(10,10);
		IslandRule rule = new IslandRule();
		
		map = rule.getRuling(map);		
		map.printMap();
	}
}
