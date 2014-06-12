package model;

public class IslandRule implements Rule {
	
	public static int NORTH_EDGE = 0;
	public static int EAST_EDGE = 1;
	public static int SOUTH_EDGE = 2;
	public static int WEST_EDGE = 3;

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

			System.out.print(i);
			System.out.print(0);

			theMap.setTile(i, 0, waterTile);

			Tile waterTile2 = new Tile();
			waterTile2.setSaturation(100);

			System.out.print(i);
			System.out.print(theMap.getLengthY() - 1);
			System.out.print('\n');

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
		
		int waterPercentage = 30;
		
		
		
		
	}

	@Override
	public Map getRuling(Map theMap, String[][] args) {
		// TODO Auto-generated method stub
		return null;
	}
}
