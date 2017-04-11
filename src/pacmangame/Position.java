package pacmangame;



/**
 * This class creates position objects that are used to associate boardpiece objects with board spaces<br>
 * It provides a constructor, getters and setters<br>
 * 
 * 
 * @author Eliezer Labell
 *
 */
public class Position {
	
	
	protected boolean visited = false;
	private static final int xMin = 1; //limits of the board's size
	private static final int yMin = 1;
	private static final int xMax = 20;
	private static final int yMax = 21;

	private int xPos;
	private int yPos;
	
	/**
	 * Creates new position object
	 * @param x x value 
	 * @param y y value
	 */
	public Position(int x, int y) {
		if (x > xMax) {
			this.xPos = xMax;
		} else if (x < xMin) {
			this.xPos = xMin;
		} else {
			this.xPos = x;
		}
		
		if (y > yMax) {
			this.yPos = yMax;
		} else if (y < yMin) {
			this.yPos = yMin;
		} else {
			this.yPos = y;
		}
		this.visited = false;
	}
	
	/**
	 * What's x
	 * @return x value
	 */
	public int getX() {
		return this.xPos;
	}
	
	/**
	 * what's y
	 * @return y value
	 */
	public int getY() {
		return this.yPos;
	}
	
	/**
	 * set x to parameter
	 * @param x new x value
	 */
	public void setX(int x) {
		if (x > xMax) {
		} else if (x < xMin) {
		} else {
			this.xPos = x;
		}
	}
	
	/**
	 * Set y value to parameter
	 * @param y new value
	 */
	public void setY(int y) {
		if (y > yMax) {
		} else if (y < yMin) {
		} else {
			this.xPos = y;
		}
	}
	
	/**
	 * create new position object directly above parameter
	 * @param p reference position
	 * @return new position
	 */
	public static Position getUp(Position p) {
		return new Position(p.getX(), p.getY() - 1);
	}
	
	/**
	 * create new position object directly below parameter
	 * @param p reference position
	 * @return new position
	 */
	public static Position getDown(Position p) {
		return new Position(p.getX(), p.getY() + 1);
	}
	
	/**
	 * create new position object directly left of parameter
	 * @param p reference position
	 * @return new position
	 */
	public static Position getLeft(Position p) {
		return new Position(p.getX() - 1, p.getY());
	}
	
	/**
	 * create new position object directly right of parameter
	 * @param p reference position
	 * @return new position
	 */
	public static Position getRight(Position p) {
		return new Position(p.getX() + 1, p.getY());
	}
	
	
	
}
