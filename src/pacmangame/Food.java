package pacmangame;


/**
 * This class constructs food objects with value 10 and populates the relevant data structures held in board state with those objects<br>
 * 
 * 
 * 
 * @author Eliezer Labell
 *
 */
public class Food extends BoardPiece {
	
	private static int points = 10; 
	private boolean powers;
	
	public Food(Position pos, boolean powers) {
		super(pos, points, true);
		this.powers = powers;
		BoardState.foodPlacement.add(this);
		BoardState.things.put(pos, this);
	}

}
