package model;

public class Map {
	private int lengthX = -1;
	private int lengthY = -1;
	private Tile[][] generatedMap;
	
	/**
	 * creates a new empty map object of the desired sizeX, and sizeY
	 * 
	 * @param sizeX
	 * @param sizeY
	 */
	public Map(int sizeX, int sizeY){
		this.lengthX = sizeX;
		this.lengthY = sizeY;
		this.generatedMap = new Tile[sizeX][sizeY];
		
	}
	
	/**
	 * returns the length of the map in the horizontal direction
	 * 
	 * @return
	 */
	public int getLengthX() {
		return this.lengthX;
	}

	/**
	 * returns the length of the map in the vertical direction
	 * 
	 * @return
	 */
	public int getLengthY() {
		return this.lengthY;
	}
	
	/**
	 * returns the length of the perimeter of the map
	 * 
	 * @return
	 */
	public int getPerimeterLength(){
		
		return this.lengthX*2 + (this.lengthY-2)*2;
	}
	
	/**
	 * takes the x,y coordinate and a Tile to be assigned to the given coordinate and sets the tile to that position.
	 * 
	 * @param theX
	 * @param theY
	 * @param theTile
	 */
	public void setTile(int theX, int theY, Tile theTile){
		if (theX > this.lengthX){
			throw new IllegalArgumentException("X range is to big. Max size " + this.lengthX);			
		}
		if (theY > this.lengthY){
			throw new IllegalArgumentException("Y range is to big. Max size " + this.lengthY);			
		}
		this.generatedMap[theX][theY] = theTile;
	}
	
	/**
	 * returns the tile at the given coordinate
	 * 
	 * @param theX
	 * @param theY
	 * @return
	 */
	public Tile getTile(int theX, int theY){
		return this.generatedMap[theX][theY];
	}
}
