package model;

public final class MapGenerator {
	
	
	/**
	 * create a blank map object array of the given size
	 * 
	 * @param theLength
	 * @param theWidth
	 * @return 
	 * @return
	 */
	public static Map makeEmptyMap(int theLength, int theWidth){
		Map theMap = new Map(theLength, theWidth);
		fillMap(theMap, new Tile());
		return theMap;
	}
	
	/**
	 * fill map with specified tile
	 * 
	 * @param theMap
	 * @param theTile
	 * @return
	 */
	public static void fillMap(Map theMap, Tile theTile){
		int i;
		int j;
		
		for (i = 0; i < theMap.getLengthX(); i++){
			for (j = 0; j < theMap.getLengthY(); j ++){
				theMap.setTile(i, j, theTile);
			}
		}
	}
}
