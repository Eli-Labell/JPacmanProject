package pacmangame;

public class Pacman extends BoardPiece {
	
	private static final boolean[] type = new boolean[] {false, false, false, false, true};
	private static final int pointValue = -100;
	boolean[] legalMoves = new boolean[] {false, false, false, false};
	
	
	public Pacman(int[][] pos) {
		super(type, pos, pointValue, true);
		BoardState.stuff.put(pos, this);
	}
	
	public void move(int[][] newPos) {
		if (BoardState.things.get(newPos) instanceof Walls) {
			
		} else if (BoardState.things.get(newPos) instanceof Food) {
			eatFood(newPos);
			BoardState.stuff.remove(this.getPos());
			BoardState.stuff.put(newPos, this);
		} else if (BoardState.stuff.get(newPos) instanceof Ghosts) {
			if (((Ghosts) BoardState.stuff.get(newPos)).isMean()) {
				getEaten(newPos);
			} else {
				eatFood(newPos);
			}
		} else {
			BoardState.stuff.remove(this.getPos());
			BoardState.stuff.put(newPos, this);
		}
	}
	
	public void eatFood(int[][] pacoPos) {
		if (BoardState.things.get(pacoPos) instanceof Food) {
			BoardState.score += BoardState.things.get(pacoPos).getPoints();
			BoardState.things.remove(pacoPos); //somehow stop this food from being visualized
		} else if (BoardState.things.get(pacoPos) instanceof Ghosts) {
			BoardState.score += BoardState.stuff.get(pacoPos).getPoints();
			BoardState.stuff.remove(pacoPos); //reset ghost to beginning
		}
	}
	
	public void getEaten(int[][] pacoPos) {
		System.exit(0); // paco is kill
	}
	
	

}
