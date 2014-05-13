package Model;

import java.util.Random;

public class RiverRule implements Rule {
	
	@Override
	public Map getRuling(Map theMap) {
		// TODO Auto-generated method stub
		
		int riverStart = RandomGenerator.getInstance().nextInt(4);
		int riverStop = RandomGenerator.getInstance().nextInt(4);
		
		int StartLocationX;
		int StartLocationY;
		
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
		
		return theMap;
	}
}
