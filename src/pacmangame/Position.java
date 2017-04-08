package pacmangame;



/**
 * Class that replaces int arrays as a way to hold the position of board piece objects
 * @author labelle
 *
 */
public class Position {

	private int xPos;
	private int yPos;
	
	public Position(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	
	
	
}
