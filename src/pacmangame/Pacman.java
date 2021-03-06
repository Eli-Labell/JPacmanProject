package pacmangame;

/**
 * Pacman class controls the various facets of pacman life<br>
 * There is only one pacman needed in a map so a static variable exists in board state that holds the used pacman object<br>
 * 
 * 
 * @author labelle
 *
 */

public class Pacman extends BoardPiece {
	
	private static final int pointValue = -100;

	
	/**
	 * constructor for the pacman
	 * 
	 * @param p where does he start?
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
			newPos = Position.getUp(placeHolder);
		} else if (i == 2) { //down
			Position placeHolder = BoardState.paco.getPos();
			newPos = Position.getDown(placeHolder);
		} else if (i == 3) { //left
			Position placeHolder = BoardState.paco.getPos();
			newPos = Position.getLeft(placeHolder);
		} else { //right
			Position placeHolder = BoardState.paco.getPos();
			newPos = Position.getRight(placeHolder);
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
			BoardState.things.put(pacoPos, new EmptySpace(pacoPos));
		} else if (BoardState.things.get(pacoPos) instanceof Ghosts) {
			BoardState.score += BoardState.stuff.get(pacoPos).getPoints();
			BoardState.stuff.remove(pacoPos); //reset ghost to beginning
		}
	}
	
	/**
	 * Paco is kill
	 * 
	 * @param pacoPos where is paco
	 */
	public static void getEaten(Position pacoPos) {
		System.exit(0); // paco is kill
	}
	
	

}
