package pacmangame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the board state class<br>
 * It keeps track of board piece objects and their properties<br>
 * It holds data structures that are referenced from other classes to test is moves are legal<br>
 * 
 * 
 * @author Eliezer Labell
 *
 */
public class BoardState {
	
	
	
	public static Pacman paco; //all pacman information requests should go here
	
	
	public static int score = 0;
	public static int time = 50000; //time counts down
	public static ArrayList<Walls> wallPlacement = new ArrayList<>();
	public static ArrayList<Food> foodPlacement = new ArrayList<>();
	public static Map<Position, BoardPiece> things = new HashMap<>(); //for static pieces
	public static Map<Position, BoardPiece> stuff = new HashMap<>(); //for dynamic pieces
	
	
	//instantiate the initial board pieces where they should be and add them to the pertinent data structures
	public static void populate() {
		
		Position pacoPos = new Position(2, 2);
		paco = new Pacman(pacoPos);
		stuff.put(pacoPos,  paco);
		
		Position inky = new Position(10, 10);
		Ghosts inkyG = new Ghosts(inky);
		stuff.put(inky, inkyG);
		Position blinky = new Position(10, 11);
		Ghosts blinkyG = new Ghosts(blinky);
		stuff.put(blinky,  blinkyG);
		Position pinky = new Position(9, 11);
		Ghosts pinkyG = new Ghosts(pinky);
		stuff.put(pinky,  pinkyG);
		Position daniel = new Position(10, 12);
		Ghosts danielG = new Ghosts(daniel);
		stuff.put(daniel,  danielG);
		
		
		int x = 1;
		while (x < 22) { //top walls
			things.put(new Position(x, 1), new Walls(new Position(x, 1)));
			x++;
		}
		x = 1;
		while (x < 22) { //bottom walls
			things.put(new Position(x, 20), new Walls(new Position(x, 20)));
			x++;
		}
		int y = 1;
		while (y < 21) { //left walls
			things.put(new Position(1, y), new Walls(new Position(1, y)));
			y++;
		}
		y = 1;
		while (y < 21) { //right walls
			things.put(new Position(21, y), new Walls(new Position(21, y)));
			y++;
		}
		x = 2;
		while (x < 21) { //top empty line
			things.put(new Position(x, 2), new Food(new Position(x, 2), false));
			x++;
		}
		x = 2;
		while (x < 21) { //bottom empty line
			things.put(new Position(x, 19), new Food(new Position(x, 19), false));
			x++;
		}
		y = 2;
		while (y < 20) { //left empty line
			things.put(new Position(2, y), new Food(new Position(2, y), false));
			y++;
		}
		y = 2;
		while (y < 20) { //right empty line
			things.put(new Position(20, y), new Food(new Position(20, y), false));
			y++;
		}
		
		things.put(new Position(3, 3), new Walls(new Position(3, 3))); //third row
		things.put(new Position(4, 3), new Walls(new Position(4, 3)));
		things.put(new Position(5, 3), new Walls(new Position(5, 3)));
		things.put(new Position(6, 3), new Food(new Position(6, 3), false));
		things.put(new Position(7, 3), new Walls(new Position(7, 3)));
		things.put(new Position(8, 3), new Walls(new Position(8, 3)));
		things.put(new Position(9, 3), new Walls(new Position(9, 3)));
		things.put(new Position(10, 3), new Food(new Position(10, 3), false));
		things.put(new Position(11, 3), new Walls(new Position(11, 3)));
		things.put(new Position(12, 3), new Food(new Position(12, 3), false));
		things.put(new Position(13, 3), new Walls(new Position(13, 3)));
		things.put(new Position(14, 3), new Walls(new Position(14, 3)));
		things.put(new Position(15, 3), new Walls(new Position(15, 3)));
		things.put(new Position(16, 3), new Food(new Position(16, 3), false));
		things.put(new Position(17, 3), new Walls(new Position(17, 3)));
		things.put(new Position(18, 3), new Walls(new Position(18, 3)));
		things.put(new Position(19, 3), new Walls(new Position(19, 3)));
		
		things.put(new Position(3, 4), new Walls(new Position(3, 4))); //fourth row
		things.put(new Position(4, 4), new Walls(new Position(4, 4)));
		things.put(new Position(5, 4), new Walls(new Position(5, 4)));
		things.put(new Position(6, 4), new Food(new Position(6, 4), false));
		things.put(new Position(7, 4), new Walls(new Position(7, 4)));
		things.put(new Position(8, 4), new Walls(new Position(8, 4)));
		things.put(new Position(9, 4), new Walls(new Position(9, 4)));
		things.put(new Position(10, 4), new Food(new Position(10, 4), false));
		things.put(new Position(11, 4), new Walls(new Position(11, 4)));
		things.put(new Position(12, 4), new Food(new Position(12, 4), false));
		things.put(new Position(13, 4), new Walls(new Position(13, 4)));
		things.put(new Position(14, 4), new Walls(new Position(14, 4)));
		things.put(new Position(15, 4), new Walls(new Position(15, 4)));
		things.put(new Position(16, 4), new Food(new Position(16, 4), false));
		things.put(new Position(17, 4), new Walls(new Position(17, 4)));
		things.put(new Position(18, 4), new Walls(new Position(18, 4)));
		things.put(new Position(19, 4), new Walls(new Position(19, 4)));
		
		x = 2;
		while (x < 11) { //fifth line
			things.put(new Position(x, 2), new Food(new Position(x, 5), false));
			x++;
		}
		things.put(new Position(11, 5), new Walls(new Position(11, 5)));
		x = 12;
		while (x < 21) { //fifth line
			things.put(new Position(x, 2), new Food(new Position(x, 5), false));
			x++;
		}
		
		
		
		things.put(new Position(3, 6), new Walls(new Position(3, 6))); //sixth row
		things.put(new Position(4, 6), new Walls(new Position(4, 6)));
		things.put(new Position(5, 6), new Walls(new Position(5, 6)));
		things.put(new Position(6, 6), new Food(new Position(6, 6), false));
		things.put(new Position(7, 6), new Walls(new Position(7, 6)));
		things.put(new Position(8, 6), new Food(new Position(8, 6), false));
		things.put(new Position(9, 6), new Walls(new Position(9, 6)));
		things.put(new Position(10, 6), new Food(new Position(10, 6), false));
		things.put(new Position(11, 6), new Food(new Position(11, 6), false));
		things.put(new Position(12, 6), new Food(new Position(12, 6), false));
		things.put(new Position(13, 6), new Walls(new Position(13, 6)));
		things.put(new Position(14, 6), new Food(new Position(14, 6), false));
		things.put(new Position(15, 6), new Walls(new Position(15, 6)));
		things.put(new Position(16, 6), new Food(new Position(16, 6), false));
		things.put(new Position(17, 6), new Walls(new Position(17, 6)));
		things.put(new Position(18, 6), new Walls(new Position(18, 6)));
		things.put(new Position(19, 6), new Walls(new Position(19, 6)));
		
		
		things.put(new Position(3, 7), new Walls(new Position(3, 7))); //seventh row
		things.put(new Position(4, 7), new Food(new Position(4, 7), true));
		things.put(new Position(5, 7), new Food(new Position(5, 7), false));
		things.put(new Position(6, 7), new Food(new Position(6, 7), false));
		things.put(new Position(7, 7), new Walls(new Position(7, 7)));
		things.put(new Position(8, 7), new Food(new Position(8, 7), false));
		things.put(new Position(9, 7), new Walls(new Position(9, 7)));
		things.put(new Position(10, 7), new Walls(new Position(10, 7)));
		things.put(new Position(11, 7), new Walls(new Position(11, 7)));
		things.put(new Position(12, 7), new Walls(new Position(12, 7)));
		things.put(new Position(13, 7), new Walls(new Position(13, 7)));
		things.put(new Position(14, 7), new Food(new Position(14, 7), false));
		things.put(new Position(15, 7), new Walls(new Position(15, 7)));
		things.put(new Position(16, 7), new Food(new Position(16, 7), false));
		things.put(new Position(17, 7), new Food(new Position(17, 7), false));
		things.put(new Position(18, 7), new Food(new Position(18, 7), true));
		things.put(new Position(19, 7), new Walls(new Position(19, 7)));
		
		things.put(new Position(3, 8), new Walls(new Position(3, 8))); //eighth row
		things.put(new Position(4, 8), new Food(new Position(4, 8), false));
		things.put(new Position(5, 8), new Walls(new Position(5, 8)));
		things.put(new Position(6, 8), new Food(new Position(6, 8), false));
		things.put(new Position(7, 8), new Walls(new Position(7, 8)));
		things.put(new Position(8, 8), new Food(new Position(8, 8), false));
		things.put(new Position(9, 8), new Food(new Position(9, 8), false));
		things.put(new Position(10, 8), new Food(new Position(10, 8), false));
		things.put(new Position(11, 8), new Food(new Position(11, 8), false));
		things.put(new Position(12, 8), new Food(new Position(12, 8), false));
		things.put(new Position(13, 8), new Food(new Position(13, 8), false));
		things.put(new Position(14, 8), new Food(new Position(14, 8), false));
		things.put(new Position(15, 8), new Walls(new Position(15, 8)));
		things.put(new Position(16, 8), new Food(new Position(16, 8), false));
		things.put(new Position(17, 8), new Walls(new Position(17, 8)));
		things.put(new Position(18, 8), new Food(new Position(18, 8), false));
		things.put(new Position(19, 8), new Walls(new Position(19, 8)));
		
		things.put(new Position(3, 9), new Food(new Position(3, 9), false)); //ninth row
		things.put(new Position(4, 9), new Food(new Position(4, 9), false));
		things.put(new Position(5, 9), new Walls(new Position(5, 9)));
		things.put(new Position(6, 9), new Food(new Position(6, 9), false));
		things.put(new Position(7, 9), new Food(new Position(7, 9), false));
		things.put(new Position(8, 9), new Food(new Position(8, 9), false));
		things.put(new Position(9, 9), new Walls(new Position(9, 9)));
		things.put(new Position(10, 9), new Walls(new Position(10, 9)));
		things.put(new Position(11, 9), new Food(new Position(11, 9), false));
		things.put(new Position(12, 9), new Walls(new Position(12, 9)));
		things.put(new Position(13, 9), new Walls(new Position(13, 9)));
		things.put(new Position(14, 9), new Food(new Position(14, 9), false));
		things.put(new Position(15, 9), new Food(new Position(15, 9), false));
		things.put(new Position(16, 9), new Food(new Position(16, 9), false));
		things.put(new Position(17, 9), new Walls(new Position(17, 9)));
		things.put(new Position(18, 9), new Food(new Position(18, 9), false));
		things.put(new Position(19, 9), new Food(new Position(19, 9), false));
		
		things.put(new Position(3, 10), new Walls(new Position(3, 10))); //tenth row
		things.put(new Position(4, 10), new Walls(new Position(4, 10)));
		things.put(new Position(5, 10), new Walls(new Position(5, 10)));
		things.put(new Position(6, 10), new Food(new Position(6, 10), false));
		things.put(new Position(7, 10), new Walls(new Position(7, 10)));
		things.put(new Position(8, 10), new Food(new Position(8, 10), false));
		things.put(new Position(9, 10), new Walls(new Position(9, 10)));
		things.put(new Position(10, 10), new Food(new Position(10, 10), false));
		things.put(new Position(11, 10), new Food(new Position(11, 10), false));
		things.put(new Position(12, 10), new Food(new Position(12, 10), false));
		things.put(new Position(13, 10), new Walls(new Position(13, 10)));
		things.put(new Position(14, 10), new Food(new Position(14, 10), false));
		things.put(new Position(15, 10), new Walls(new Position(15, 10)));
		things.put(new Position(16, 10), new Food(new Position(16, 10), false));
		things.put(new Position(17, 10), new Walls(new Position(17, 10)));
		things.put(new Position(18, 10), new Walls(new Position(18, 10)));
		things.put(new Position(19, 10), new Walls(new Position(19, 10)));
		
		things.put(new Position(3, 11), new Food(new Position(3, 11), false)); //eleventh row
		things.put(new Position(4, 11), new Food(new Position(4, 11), false));
		things.put(new Position(5, 11), new Walls(new Position(5, 11)));
		things.put(new Position(6, 11), new Food(new Position(6, 11), false));
		things.put(new Position(7, 11), new Food(new Position(7, 11), false));
		things.put(new Position(8, 11), new Food(new Position(8, 11), false));
		things.put(new Position(9, 11), new Walls(new Position(9, 11)));
		things.put(new Position(10, 11), new Walls(new Position(10, 11)));
		things.put(new Position(11, 11), new Walls(new Position(11, 11)));
		things.put(new Position(12, 11), new Walls(new Position(12, 11)));
		things.put(new Position(13, 11), new Walls(new Position(13, 11)));
		things.put(new Position(14, 11), new Food(new Position(14, 11), false));
		things.put(new Position(15, 11), new Food(new Position(15, 11), false));
		things.put(new Position(16, 11), new Food(new Position(16, 11), false));
		things.put(new Position(17, 11), new Walls(new Position(17, 11)));
		things.put(new Position(18, 11), new Food(new Position(18, 11), false));
		things.put(new Position(19, 11), new Food(new Position(19, 11), false));
		
		things.put(new Position(3, 12), new Walls(new Position(3, 12))); //twelfth row
		things.put(new Position(4, 12), new Food(new Position(4, 12), false));
		things.put(new Position(5, 12), new Walls(new Position(5, 12)));
		things.put(new Position(6, 12), new Food(new Position(6, 12), false));
		things.put(new Position(7, 12), new Walls(new Position(7, 12)));
		things.put(new Position(8, 12), new Food(new Position(8, 12), false));
		things.put(new Position(9, 12), new Food(new Position(9, 12), false));
		things.put(new Position(10, 12), new Food(new Position(10, 12), false));
		things.put(new Position(11, 12), new Food(new Position(11, 12), true));
		things.put(new Position(12, 12), new Food(new Position(12, 12), false));
		things.put(new Position(13, 12), new Food(new Position(13, 12), false));
		things.put(new Position(14, 12), new Food(new Position(14, 12), false));
		things.put(new Position(15, 12), new Walls(new Position(15, 12)));
		things.put(new Position(16, 12), new Food(new Position(16, 12), false));
		things.put(new Position(17, 12), new Walls(new Position(17, 12)));
		things.put(new Position(18, 12), new Food(new Position(18, 12), false));
		things.put(new Position(19, 12), new Walls(new Position(19, 12)));
		
		things.put(new Position(3, 13), new Walls(new Position(3, 13))); //thirteenth row
		things.put(new Position(4, 13), new Food(new Position(4, 13), false));
		things.put(new Position(5, 13), new Food(new Position(5, 13), false));
		things.put(new Position(6, 13), new Food(new Position(6, 13), false));
		things.put(new Position(7, 13), new Food(new Position(7, 13), false));
		things.put(new Position(8, 13), new Food(new Position(8, 13), false));
		things.put(new Position(9, 13), new Walls(new Position(9, 13)));
		things.put(new Position(10, 13), new Walls(new Position(10, 13)));
		things.put(new Position(11, 13), new Walls(new Position(11, 13)));
		things.put(new Position(12, 13), new Walls(new Position(12, 13)));
		things.put(new Position(13, 13), new Walls(new Position(13, 13)));
		things.put(new Position(14, 13), new Food(new Position(14, 13), false));
		things.put(new Position(15, 13), new Food(new Position(15, 13), false));
		things.put(new Position(16, 13), new Food(new Position(16, 13), false));
		things.put(new Position(17, 13), new Food(new Position(17, 13), false));
		things.put(new Position(18, 13), new Food(new Position(18, 13), false));
		things.put(new Position(19, 13), new Walls(new Position(19, 13)));
		
		things.put(new Position(3, 14), new Walls(new Position(3, 14))); //fourteenth row
		things.put(new Position(4, 14), new Food(new Position(4, 14), false));
		things.put(new Position(5, 14), new Walls(new Position(5, 14))); 
		things.put(new Position(6, 14), new Walls(new Position(6, 14))); 
		things.put(new Position(7, 14), new Walls(new Position(7, 14))); 
		things.put(new Position(8, 14), new Food(new Position(8, 14), false));
		things.put(new Position(9, 14), new Food(new Position(9, 14), false));
		things.put(new Position(10, 14), new Food(new Position(10, 14), false));
		things.put(new Position(11, 14), new Walls(new Position(11, 14))); 
		things.put(new Position(12, 14), new Food(new Position(12, 14), false));
		things.put(new Position(13, 14), new Food(new Position(13, 14), false));
		things.put(new Position(14, 14), new Food(new Position(14, 14), false));
		things.put(new Position(15, 14), new Walls(new Position(15, 14))); //fourteenth row
		things.put(new Position(16, 14), new Walls(new Position(16, 14))); //fourteenth row
		things.put(new Position(17, 14), new Walls(new Position(17, 14))); //fourteenth row
		things.put(new Position(18, 14), new Food(new Position(18, 14), false));
		things.put(new Position(19, 14), new Walls(new Position(19, 14))); //fourteenth row
		
		things.put(new Position(3, 15), new Walls(new Position(3, 15))); //fifteenth row
		
		
		
		
		
		things.put(new Position(9, 15), new Walls(new Position(9, 15)));
		
		
		
		things.put(new Position(13, 15), new Walls(new Position(13, 15)));
		
		
		
		
		
		things.put(new Position(19, 15), new Walls(new Position(19, 15)));
		
		things.put(new Position(3, 16), new Walls(new Position(3, 16))); //sixteenth row
		things.put(new Position(4, 16), new Walls(new Position(4, 16)));
		
		things.put(new Position(6, 16), new Walls(new Position(6, 16)));
		
		things.put(new Position(8, 16), new Walls(new Position(8, 16)));
		things.put(new Position(9, 16), new Walls(new Position(9, 16)));
		things.put(new Position(10, 16), new Walls(new Position(10, 16)));
		things.put(new Position(11, 16), new Walls(new Position(11, 16)));
		things.put(new Position(12, 16), new Walls(new Position(12, 16)));
		things.put(new Position(13, 16), new Walls(new Position(13, 16)));
		things.put(new Position(14, 16), new Walls(new Position(14, 16)));
		
		things.put(new Position(16, 16), new Walls(new Position(16, 16)));
		
		things.put(new Position(18, 16), new Walls(new Position(18, 16)));
		things.put(new Position(19, 16), new Walls(new Position(19, 16)));
		
//		things.put(new Position(3, 17), new Walls(new Position(3, 17))); //seventeenth row
		
		
		things.put(new Position(6, 17), new Walls(new Position(6, 17)));
		
		
		
		
		things.put(new Position(11, 17), new Walls(new Position(11, 17)));
		
		
		
		
		things.put(new Position(16, 17), new Walls(new Position(16, 17)));
		
		
		things.put(new Position(3, 18), new Walls(new Position(3, 18))); //eighteenth row
		things.put(new Position(4, 18), new Walls(new Position(4, 18)));
		things.put(new Position(5, 18), new Walls(new Position(5, 18)));
		things.put(new Position(6, 18), new Walls(new Position(6, 18)));
		things.put(new Position(7, 18), new Walls(new Position(7, 18)));
		things.put(new Position(8, 18), new Walls(new Position(8, 18)));
		things.put(new Position(9, 18), new Walls(new Position(9, 18)));
		
		things.put(new Position(11, 18), new Walls(new Position(11, 18)));
		
		things.put(new Position(13, 18), new Walls(new Position(13, 18)));
		things.put(new Position(14, 18), new Walls(new Position(14, 18)));
		things.put(new Position(15, 18), new Walls(new Position(15, 18)));
		things.put(new Position(16, 18), new Walls(new Position(16, 18)));
		things.put(new Position(17, 18), new Walls(new Position(17, 18)));
		things.put(new Position(18, 18), new Walls(new Position(18, 18)));
		things.put(new Position(19, 18), new Walls(new Position(19, 18)));
	
		
		
	
	//why are you like this?
	}
}
