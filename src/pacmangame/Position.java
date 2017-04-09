package pacmangame;

//get left right etc methods to return objects of adjacent pos.

/**
 * Class that replaces int arrays as a way to hold the position of board piece objects
 * @author labelle
 *
 */
public class Position {
	
	private static final int xMin = 1;
	private static final int yMin = 1;
	private static final int xMax = 20;
	private static final int yMax = 21;

	private int xPos;
	private int yPos;
	
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
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public void setX(int x) {
		if (x > xMax) {
		} else if (x < xMin) {
		} else {
			this.xPos = x;
		}
	}
	
	public void setY(int y) {
		if (y > yMax) {
		} else if (y < yMin) {
		} else {
			this.xPos = y;
		}
	}
	
	public static Position getUp(Position p) {
		return new Position(p.getX(), p.getY() + 1);
	}
	
	public static Position getDown(Position p) {
		return new Position(p.getX(), p.getY() - 1);
	}
	
	public static Position getLeft(Position p) {
		return new Position(p.getX() - 1, p.getY());
	}
	
	public static Position getRight(Position p) {
		return new Position(p.getX() + 1, p.getY());
	}
	
	
	
}
