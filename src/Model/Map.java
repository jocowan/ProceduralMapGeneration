package Model;

public class Map {
	private int lengthX = -1;
	private int lengthY = -1;
	private Tile[][] generatedMap = null;
	
	public int getLengthX() {
		return lengthX;
	}

	public int getLengthY() {
		return lengthY;
	}

	/**
	 * create a blank map object array of the given size
	 * 
	 * @param theLength
	 * @param theWidth
	 * @return 
	 * @return
	 */
	public void makeEmptyMap(int theLength, int theWidth){
		this.lengthX = theLength;
		this.lengthY = theWidth;
		
		Tile[][] theMap = new Tile[this.lengthX][this.lengthY];
		this.generatedMap = theMap;
	}
	
	public void fillMap(){
		// TODO add function
	}
	
	public void setTile(int theX, int theY, Tile theTile){
		if (theX > this.lengthX){
			throw new IllegalArgumentException("X range is to big. Max size " + this.lengthX);			
		}
		if (theY > this.lengthY){
			throw new IllegalArgumentException("Y range is to big. Max size " + this.lengthY);			
		}
		this.generatedMap[theX][theY] = theTile;
	}
}
