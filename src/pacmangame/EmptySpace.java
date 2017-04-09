package pacmangame;

public class EmptySpace extends BoardPiece {
	
	protected boolean visited = false;
	
	public EmptySpace(Position p, boolean visit) {
		super(p, 0, false);
		this.visited = visit;
	}
	
	
	
	
	
}
