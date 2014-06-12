package model;

public class IslandRule implements Rule {

	public Map getRuling(Map theMap, String args[]) {
		surroundMap(theMap);
		shapeMap(theMap, args);
		
		return theMap;
	}

	private void surroundMap(Map theMap) {
		int i;

		for (i = 0; i < theMap.getLengthX(); i++) {
			Tile waterTile = new Tile();
			waterTile.setSaturation(100);
			waterTile.setElevation(0);

			theMap.setTile(i, 0, waterTile);

			Tile waterTile2 = new Tile();
			waterTile2.setSaturation(100);

			theMap.setTile(i, theMap.getLengthY() - 1, waterTile2);
		}

		for (i = 0; i < theMap.getLengthY(); i++) {
			Tile waterTile = new Tile();
			waterTile.setSaturation(100);
			theMap.setTile(0, i, waterTile);

			Tile waterTile2 = new Tile();
			waterTile2.setSaturation(100);
			theMap.setTile(theMap.getLengthX() - 1, i, waterTile2);
		}
	}
	
	private void shapeMap(Map theMap, String[] args){
		// init for loop variables
		int i;
		int j;
		
		// magic mater percentage
		int waterPercentage = 30;
		
		RandomGenerator.getInstance().nextInt(TOTAL_EDGE);
		
		
		
		
	}
}
