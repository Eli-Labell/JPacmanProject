package pacmangame;


/**
 * This is the Abstract Superclass of every board game object<br>
 * It provides the variables and methods that apply to every board object<br>
 * 
 * 
 * 
 * @author Eliezer Labell
 *
 */
public abstract class BoardPiece {
	
	protected boolean[] whatAmI = new boolean[] {false, false, false, false, false}; //wall, food, empty space, ghost, pacman
	protected Position whereAmI; //y,x
	protected int pointValue; //when removed increment score with point value of object
	protected boolean visable; //when not visable, don't show to the player
	protected boolean visited = false;
	
	
	/**
	 * Constructor for board piece objects
	 * 
	 * @param que what type is this object
	 * @param p where is the object on the board
	 * @param puntos how many points is this piece worth?
	 * @param visable can the player see this object?
	 */
	public BoardPiece(boolean[] que, Position p, int puntos, boolean visable) {
		this.whatAmI = que;
		this.whereAmI = p;
		this.pointValue = puntos;
		this.visable = visable;
		this.visited = false;
	}
	
	/**
	 * Returns the type of board object this is
	 * @return type
	 */
	public boolean[] getType() {
		return this.whatAmI;
	}
	
	/**
	 * Return object of position of this object
	 * @return position object
	 */
	public Position getPos() {
		return this.whereAmI;
	}
	
	/**
	 * Return the value of this boardpiece
	 * @return int value of points
	 */
	public int getPoints() {
		return this.pointValue;
	}
	
	/**
	 * Returns whether a board piece object is visable
	 * @return true if visable
	 */
	public boolean isVisable() {
		return this.visable;
	}
	
	
	
	
}
