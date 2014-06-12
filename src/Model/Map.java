package model;

public class Map {
	private int lengthX = -1;
	private int lengthY = -1;
	private Tile[][] generatedMap;
	
	public Map(int sizeX, int sizeY){
		this.lengthX = sizeX;
		this.lengthY = sizeY;
		this.generatedMap = new Tile[sizeX][sizeY];
		
	}
	
	
	public int getLengthX() {
		return this.lengthX;
	}

	public int getLengthY() {
		return this.lengthY;
	}
	
	public int getPerimeterLength(){
		
		return this.lengthX*2 + (this.lengthY-2)*2;
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
	
	public Tile getTile(int theX, int theY){
		return this.generatedMap[theX][theY];
	}
}
