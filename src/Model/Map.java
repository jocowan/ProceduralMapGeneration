package Model;

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
		return lengthX;
	}

	public int getLengthY() {
		return lengthY;
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
		return generatedMap[theX][theY];
	}
	
	public void printMap(){
		int i = 0;
		int j = 0;
		
		System.out.print("+");
		for (i = 0; i < this.lengthX; i++){
			System.out.print(" - +");
		}		
		for (i = 0; i < this.lengthX; i++) {
			System.out.print("\n");
			System.out.print("|");
			for (j = 0; j < this.lengthY; j++ ) {
				if (generatedMap[i][j].getSaturation() == 100){
					System.out.print(" w |");
				}
				else if (generatedMap[i][j].getSaturation() == 0){
					System.out.print( " l |");
				}
				else if (generatedMap[i][j].getSaturation() == 0 && generatedMap[i][j].getElevation() > 0){
					System.out.print( " e |");
				}
				else if (generatedMap[i][j].getSaturation() == 50){
					System.out.print( " r |");
				}
				else {
					System.out.print( " ? |");
				}
			}
		}
		
		System.out.print("\n");
		System.out.print("+");
		for (i = 0; i < this.lengthX; i++){
			System.out.print(" - +");
		}
		System.out.print("\n");
	}
}
