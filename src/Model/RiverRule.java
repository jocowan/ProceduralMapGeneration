package model;

public class RiverRule implements Rule {
	
	@Override
	public Map getRuling(Map theMap, String args[]) {
		// Select two sides for the river to start and finish on.
		// The sides may be the same.
		int riverStart = RandomGenerator.getInstance().nextInt(TOTAL_EDGE);
		int riverStop = RandomGenerator.getInstance().nextInt(TOTAL_EDGE);
		
		// starting x,y coords for the river
		int StartLocationX;
		int StartLocationY;
		
		// stopping x,y coords for the river
		int StopLocationX;
		int StopLocationY;
		
		if (riverStart == NORTH_EDGE || riverStart == SOUTH_EDGE) {
			StartLocationX = RandomGenerator.getInstance().nextInt(theMap.getLengthX());
			
			if (riverStart == 0){
				StartLocationY = 0;
			}
			else {
				StartLocationY = theMap.getLengthY()-1;
			}
			Tile riverTile = new Tile();
			riverTile.setSaturation(50);
			
			theMap.setTile(StartLocationX, StartLocationY, riverTile);
		}
		
		else if (riverStart == EAST_EDGE || riverStart == WEST_EDGE) {
			StartLocationY = RandomGenerator.getInstance().nextInt(theMap.getLengthY());
			
			if (riverStart == 1){
				StartLocationX = 0;
			}
			else {
				StartLocationX = theMap.getLengthX()-1;
			}
			Tile riverTile = new Tile();
			riverTile.setSaturation(50);
			
			theMap.setTile(StartLocationX, StartLocationY, riverTile);
		}
		
		if (riverStop == NORTH_EDGE || riverStop == SOUTH_EDGE) {
			StopLocationX = RandomGenerator.getInstance().nextInt(theMap.getLengthX());
			
			if (riverStop == 0){
				StopLocationY = 0;
			}
			else {
				StopLocationY = theMap.getLengthY()-1;
			}
			Tile riverTile = new Tile();
			riverTile.setSaturation(50);
			
			theMap.setTile(StopLocationX, StopLocationY, riverTile);
		}
		
		else if (riverStop == EAST_EDGE || riverStop == WEST_EDGE) {
			StopLocationY = RandomGenerator.getInstance().nextInt(theMap.getLengthY());
			
			if (riverStart == 1){
				StopLocationX = 0;
			}
			else {
				StopLocationX = theMap.getLengthX()-1;
			}
			Tile riverTile = new Tile();
			riverTile.setSaturation(50);
			
			theMap.setTile(StopLocationX, StopLocationY, riverTile);
		}
		
		return theMap;
	}
}
