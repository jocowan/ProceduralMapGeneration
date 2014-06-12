package model;

public interface Rule {
	
	public static int NORTH_EDGE = 0;
	public static int EAST_EDGE = 1;
	public static int SOUTH_EDGE = 2;
	public static int WEST_EDGE = 3;
	public static int TOTAL_EDGE = 4;
	
	public Map getRuling(Map theMap, String args[]);
}
