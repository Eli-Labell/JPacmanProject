package pacmangame;

/**
 * This class creates objects that hold empty spaces<br>
 * THey are legal moves for pacmant that cause no other events to trigger<br>
 * 
 * @author Eliezer Labell
 *
 */
public class EmptySpace extends BoardPiece {
	
	protected boolean visited = false;
	
	public EmptySpace(Position p) {
		super(p, 0, false);
		this.visited = false;
	}
	
	
	
	
	
}
