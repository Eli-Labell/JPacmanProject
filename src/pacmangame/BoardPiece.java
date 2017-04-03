package pacmangame;


//super legit super class
public abstract class BoardPiece {
	
	protected boolean[] whatAmI = new boolean[] {false, false, false, false, false}; //wall, food, empty space, ghost, pacman
	protected int[][] whereAmI = new int[20][21]; //y,x
	protected int pointValue; //when removed increment score with point value of object
	protected boolean visable; //when not visable, don't show to the player
	
	
	public BoardPiece(boolean[] que, int[][] donde, int puntos, boolean visable) {
		this.whatAmI = que;
		this.whereAmI = donde;
		this.pointValue = puntos;
		this.visable = visable;
	}
	
	public boolean[] getType() {
		return this.whatAmI;
	}
	
	public int[][] getPos() {
		return this.whereAmI;
	}
	
	public int getPoints() {
		return this.pointValue;
	}
	
	public boolean isVisable() {
		return this.visable;
	}
	
	
	
	
}
