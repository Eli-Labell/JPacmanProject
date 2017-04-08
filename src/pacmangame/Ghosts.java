package pacmangame;

public class Ghosts extends BoardPiece {
	
	private static final boolean[] type = new boolean[] {false, false, false, true, false};
	private static final int pointValue = 100;
	boolean[] legalMoves = new boolean[] {false, false, false, false};
	private boolean mean;

	
	/**
	 * Constructor for a ghost
	 * 
	 * @param pos where does the ghost start
	 */
	public Ghosts(int[][] pos) {
		super(type, pos, pointValue, true);
		this.mean = true;
		BoardState.stuff.put(pos, this);
	}
	
	public void move(int[][] newPos) {
		if (BoardState.things.get(newPos) instanceof Walls) {
			//can't do that dave
		} else if (BoardState.stuff.get(newPos) instanceof Pacman) {
			if (this.isMean()) {
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
