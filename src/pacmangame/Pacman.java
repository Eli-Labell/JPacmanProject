package pacmangame;

/**
 * Pacman class controls the various facets of pacman life
 * 
 * 
 * 
 * @author labelle
 *
 */





public class Pacman extends BoardPiece {
	
	//private static final boolean[] type = new boolean[] {false, false, false, false, true};
	private static final int pointValue = -100;
	private static boolean[] legalMoves = new boolean[] {false, false, false, false}; //can be static because there is only ever one pacman
	
	/**
	 * constructor for the pacman
	 * 
	 * @param pos where does he start?
	 */
	public Pacman(Position p) {
		super(p, pointValue, true);
		BoardState.stuff.put(p, this);
		BoardState.paco = this;
	}
	
	/**
	 * checks the contents of the proposed move to space and decides the consequnces of paco's actions
	 * 
	 * @param newPos where paco wants to go
	 */
	public static void move(Position newPos) {
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
		Position newPos;
		//find out what absolute 
		if (i == 1) { //up
			Position placeHolder = BoardState.paco.getPos();
			newPos = new Position(placeHolder.getX(), placeHolder.getY() + 1);
		} else if (i == 2) { //down
			Position placeHolder = BoardState.paco.getPos();
			newPos = new Position(placeHolder.getX(), placeHolder.getY() - 1);
		} else if (i == 3) { //left
			Position placeHolder = BoardState.paco.getPos();
			newPos = new Position(placeHolder.getX() - 1, placeHolder.getY());
		} else { //right
			Position placeHolder = BoardState.paco.getPos();
			newPos = new Position(placeHolder.getX() + 1, placeHolder.getY());
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
	public static void eatFood(Position pacoPos) {
		if (BoardState.things.get(pacoPos) instanceof Food) {
			BoardState.score += BoardState.things.get(pacoPos).getPoints();
			BoardState.things.remove(pacoPos); //somehow stop this food from being visualized
			BoardState.things.put(pacoPos, new EmptySpace(pacoPos, true));
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
	public static void getEaten(Position pacoPos) {
		System.exit(0); // paco is kill
	}
	
	

}
