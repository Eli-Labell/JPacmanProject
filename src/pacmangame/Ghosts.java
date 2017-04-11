package pacmangame;


/**
 * This class allows for the creation of ghost objects and the control of those objects<br>
 * When an object is instantiated it is added to the relevant data structure in board state<br>
 * The object can be moved by giving it a new position at which point it's information is changed
 * in the visualization as well as in the board state data structures<br>
 * 
 * 
 * @author Eliezer Labell
 *
 */
public class Ghosts extends BoardPiece {
	
	private static final int pointValue = 100;
	private boolean mean; //hostility

	/**
	 * Constructor for a ghost
	 * 
	 * @param pos where does the ghost start
	 */
	public Ghosts(Position pos) {
		super(pos, pointValue, true);
		this.mean = true;
		BoardState.stuff.put(pos, this);
	}
	
	public void move(Position newPos) {
		if (BoardState.things.get(newPos) instanceof Walls) {
			//can't do that dave
		} else if (BoardState.stuff.get(newPos) instanceof Pacman) {
			if (this.isMean()) {
				Pacman.getEaten(newPos);
				//game over man, game over
			} else {
				//ghost is kill
				//increment score
				//send ghost to restart point after x clock cycles
			}
		} else {
			BoardState.stuff.remove(this.whereAmI);
			BoardState.stuff.put(newPos, this);
			this.whereAmI = newPos; //call visualization method here
		}
	}
	
	
	/**
	 * check if the ghost is hostile
	 * 
	 * @return true = hostile
	 */
	public boolean isMean() {
		if (this.mean == true) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Toggle Ghost fear
	 */
	public void boo() {
		this.mean = !this.mean;
	}
	
	
	
}
