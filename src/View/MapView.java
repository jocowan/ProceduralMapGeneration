package view;

import java.awt.Graphics;

import model.IslandRule;
import model.Map;
import model.MapGenerator;
import model.RiverRule;

public class MapView {
	public Map getMap (String[] args){
		Map map = MapGenerator.makeEmptyMap(10,10);
		RiverRule rule = new RiverRule();
		
		map = rule.getRuling(map);				
		return map;
	}
	
	public void printMap(Map theMap){
		theMap.printMap();
	}
}
