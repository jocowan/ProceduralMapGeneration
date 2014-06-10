package model;

public class RiverRule implements Rule {
	
	@Override
	public Map getRuling(Map theMap) {
		// TODO Auto-generated method stub
		
		int riverStart = RandomGenerator.getInstance().nextInt(4);
		int riverStop = RandomGenerator.getInstance().nextInt(4);
		
		System.out.println("Start: "+riverStart);
		System.out.println("Stop "+riverStop);
		
		int StartLocationX;
		int StartLocationY;
		
		int StopLocationX;
		int StopLocationY;
		
		if (riverStart == 0 || riverStart == 2) {
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
		
		else if (riverStart == 1 || riverStart == 3) {
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
		
		if (riverStop == 0 || riverStop == 2) {
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
		
		else if (riverStop == 1 || riverStop == 3) {
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
