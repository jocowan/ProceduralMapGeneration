package Model;

public class IslandRule extends Rule {

	@Override
	protected void getRuling(Map theMap) {
		// TODO implement water to surround the map
		int i;
		
		for (i = 0; i < theMap.getLengthX(); i ++){
			Tile waterTile = new Tile();
			waterTile.setSaturation(100);
			waterTile.setElevation(0);
			theMap.setTile(i, 0, waterTile);
			
			Tile waterTile2 = new Tile();
			waterTile.setSaturation(100);
			waterTile.setElevation(0);
			theMap.setTile(i, theMap.getLengthY()-1, waterTile2);
		}
		
		for (i = 0; i < theMap.getLengthY(); i++){
			Tile waterTile = new Tile();
			waterTile.setSaturation(100);
			waterTile.setElevation(0);
			theMap.setTile(0, i, waterTile);
			
			Tile waterTile2 = new Tile();
			waterTile.setSaturation(100);
			waterTile.setElevation(0);
			theMap.setTile(theMap.getLengthX()-1, i, waterTile2);
		}
	}

}
