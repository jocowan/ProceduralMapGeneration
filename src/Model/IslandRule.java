package model;

public class IslandRule implements Rule {

	public Map getRuling(Map theMap, String args[]) {
		surroundMap(theMap);
		shapeMap(theMap, args);

		return theMap;
	}

	/**
	 * fill in the perimeter of the map with water tiles
	 * 
	 * @param theMap
	 */
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

	/**
	 * Randomly selects a non-water tile on the edge of the map to be changed.
	 * This is done until the map has a coverage of the percentage given as an
	 * argument.
	 * 
	 * @param theMap
	 * @param args
	 */
	private void shapeMap(Map theMap, String[] args) {
		// init for loop variables
		int i;
		int j;

		// magic mater percentage
		double waterPercentage = 0.3;
		int waterTileCount = 0;

		int mapSize = theMap.getLengthX() * theMap.getLengthY()
				- theMap.getPerimeterLength();

		System.out.println(waterTileCount + "/" + mapSize + "="
				+ (waterTileCount / mapSize));
		float waterCoverage = (float) waterTileCount / mapSize;

		while (waterCoverage < waterPercentage) {

			System.out.println(waterTileCount + "/" + mapSize + "="
					+ waterCoverage);
			System.out.println(waterCoverage + "<" + waterPercentage + ":"
					+ (waterCoverage < waterPercentage));

			int modifiedEdge = RandomGenerator.getInstance()
					.nextInt(TOTAL_EDGE);
			int modifiedTileCoord;

			if (modifiedEdge == NORTH_EDGE || modifiedEdge == SOUTH_EDGE) {
				modifiedTileCoord = RandomGenerator.getInstance().nextInt(
						theMap.getLengthX() - 2) + 1;

				// check to see if we need to offset j and increment
				if (modifiedEdge == NORTH_EDGE) {
					j = 1;
					System.out.println("NorthSide\nStarting coords:"
							+ modifiedTileCoord + "," + j);
					while (theMap.getTile(modifiedTileCoord, j).getSaturation() > 0) {
						j++;
					}
					System.out.println("Final coords:" + modifiedTileCoord
							+ "," + j);
				}
				// else its the south edge, so set j to the first possible south
				// edge and decrement
				else {
					j = theMap.getLengthY() - 1;
					System.out.println("SouthSide\nStarting coords:"
							+ modifiedTileCoord + "," + j);
					while (theMap.getTile(modifiedTileCoord, j).getSaturation() > 0) {
						j--;

					}
					System.out.println("Final coords:" + modifiedTileCoord
							+ "," + j);
				}

				Tile waterTile = new Tile();
				waterTile.setSaturation(100);
				theMap.setTile(modifiedTileCoord, j, waterTile);
				waterTileCount += 1;
			}

			else if (modifiedEdge == EAST_EDGE || modifiedEdge == WEST_EDGE) {
				modifiedTileCoord = RandomGenerator.getInstance().nextInt(
						theMap.getLengthY() - 2) + 1;

				// check to see if we need to offset i and increment
				if (modifiedEdge == EAST_EDGE) {
					i = 1;
					System.out.println("EastSide\nStarting coords:"
							+ modifiedTileCoord + "," + i);
					while (theMap.getTile(i, modifiedTileCoord).getSaturation() > 0) {
						i++;
					}
					System.out.println("Final coords:" + i + ","
							+ modifiedTileCoord);
				}
				// else its the south edge, so set i to the first possible south
				// edge and decrement
				else {
					i = theMap.getLengthX() - 1;
					System.out.println("WestSide\nStarting coords:"
							+ modifiedTileCoord + "," + i);
					while (theMap.getTile(i, modifiedTileCoord).getSaturation() > 0) {
						i--;
					}
					System.out.println("Final coords:" + i + ","
							+ modifiedTileCoord);
				}

				Tile waterTile = new Tile();
				waterTile.setSaturation(100);
				theMap.setTile(i, modifiedTileCoord, waterTile);
				waterTileCount += 1;
			}
			waterCoverage = (float) waterTileCount / mapSize;
		}

	}
}
