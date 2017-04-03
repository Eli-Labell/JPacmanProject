package pacmangame;

/**
 * SOMEHOW ADD PACMAN TO THE PACMAN AT THE BOARD STATE
 * 
 * 
 * 
 * @author labelle
 *
 */





public class Pacman extends BoardPiece {
	
	private static final boolean[] type = new boolean[] {false, false, false, false, true};
	private static final int pointValue = -100;
	boolean[] legalMoves = new boolean[] {false, false, false, false};
	
	/**
	 * constructor for the pacman
	 * 
	 * @param pos where does he start?
	 */
	public Pacman(int[][] pos) {
		super(type, pos, pointValue, true);
		BoardState.stuff.put(pos, this);
		
	}
	
	/**
	 * checks the contents of the proposed move to space and decides the consequnces of paco's actions
	 * 
	 * @param newPos where paco wants to go
	 */
	public static void move(int[][] newPos) {
		if (BoardState.things.get(newPos) instanceof Walls) { //can't enter a wall
			
		} else if (BoardState.things.get(newPos) instanceof Food) { //food gets eaten
			eatFood(newPos);
			BoardState.stuff.remove(BoardState.paco.getPos());
			BoardState.stuff.put(newPos, BoardState.paco);
		} else if (BoardState.stuff.get(newPos) instanceof Ghosts) {
			if (((Ghosts) BoardState.stuff.get(newPos)).isMean()) { //mean ghosts eat paco
				getEaten(newPos);
			} else {  //paco eats scardy ghosts
				eatFood(newPos);
			}
		} else { //empty space has no consequnces, just go there
			BoardState.stuff.remove(BoardState.paco.getPos());
			BoardState.stuff.put(newPos, BoardState.paco);
		}
	}
	
	/**
	 * Overload that deals with keyboard directions
	 * @param newPos
	 */
	public static boolean move(int i) {
		int[][] newPos;
		//find out what absolute 
		if (i == 1) { //up
			int[][] placeHolder = BoardState.paco.getPos();
			newPos = new int[placeHolder.length + 1][placeHolder[0].length];
		} else if (i == 2) { //down
			int[][] placeHolder = BoardState.paco.getPos();
			newPos = new int[placeHolder.length - 1][placeHolder[0].length];
		} else if (i == 3) { //left
			int[][] placeHolder = BoardState.paco.getPos();
			newPos = new int[placeHolder.length][placeHolder[0].length - 1];
		} else { //right
			int[][] placeHolder = BoardState.paco.getPos();
			newPos = new int[placeHolder.length][placeHolder[0].length + 1];
		}
		
		
		if (BoardState.things.get(newPos) instanceof Walls) { //can't enter a wall
			return false;
		} else if (BoardState.things.get(newPos) instanceof Food) { //food gets eaten
			eatFood(newPos);
			BoardState.stuff.remove(BoardState.paco.getPos());
			BoardState.stuff.put(newPos, BoardState.paco);
			return true;
		} else if (BoardState.stuff.get(newPos) instanceof Ghosts) {
			if (((Ghosts) BoardState.stuff.get(newPos)).isMean()) { //mean ghosts eat paco
				getEaten(newPos);
			} else {  //paco eats scardy ghosts
				eatFood(newPos);
			}
			return true;
		} else { //empty space has no consequnces, just go there
			BoardState.stuff.remove(BoardState.paco.getPos());
			BoardState.stuff.put(newPos, BoardState.paco);
			return true;
		}
	}
	
	
	
	
	
	
	
	/**
	 * Eat food from the board
	 * Remove it from the list of food that's on board
	 * 
	 * @param pacoPos where is the pacoman
	 */
	public static void eatFood(int[][] pacoPos) {
		if (BoardState.things.get(pacoPos) instanceof Food) {
			BoardState.score += BoardState.things.get(pacoPos).getPoints();
			BoardState.things.remove(pacoPos); //somehow stop this food from being visualized
		} else if (BoardState.things.get(pacoPos) instanceof Ghosts) {
			BoardState.score += BoardState.stuff.get(pacoPos).getPoints();
			BoardState.stuff.remove(pacoPos); //reset ghost to beginning
		}
	}
	
	/**
	 * Paco is killl
	 * 
	 * @param pacoPos where is paco
	 */
	public static void getEaten(int[][] pacoPos) {
		System.exit(0); // paco is kill
	}
	
	

}
