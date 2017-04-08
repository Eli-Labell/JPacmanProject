package pacmangame;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BoardState {
	
	//make god paco to reference from Pacman class.
	
	public static Pacman paco; //all pacman information requests should go here
	
	
	public static int score = 0;
	public static int time = 50000; //time counts down
	public static ArrayList<Walls> wallPlacement = new ArrayList<>();
	public static ArrayList<Food> foodPlacement = new ArrayList<>();
	public static Map<Position, BoardPiece> things = new TreeMap<>(); //for static pieces
	public static Map<Position, BoardPiece> stuff = new TreeMap<>(); //for dynamic pieces
	
}
