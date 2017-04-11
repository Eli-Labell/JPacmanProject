package pacmangame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
/**
 * This class contains the search algorithms, and their helper methods.
 * 
 */
public class Search {

	/**
	 * This method implements a Depth First Search algorithm. Given a start and end position (root and target),
	 * the algorithm will search to the bottom of each child node branch until the target is found. The updated
	 * path ArrayList passes the sequence of positions to a move method which calls for a sprite move method.
	 * 
	 * @param root starting node
	 * @param target desired node
	 */
	protected static void DFS(Position root, Position target) {
		root.visited = true;
		
		Set<Position> track = new HashSet<Position>();
		track.add(root);
			
		ArrayList<Position> path = new ArrayList<Position>();
		
		Stack<Position> s = new Stack<Position>();
		s.push(root);
		
		search:
			while(!s.isEmpty()) {
				path.clear();
				
				Position n = (Position)s.peek();
				Position child = getUnvisitedChildPiece(n);
				
				path.add(n);
				track.add(n);
				
				if (child != null) {
					child.visited = true;
					track.add(child);
					
					path.add(child);
					s.push(child);
					
					if (child.equals(target))
						break search;
				} else {
					s.pop();
					path.remove(path.size()-1);
				}
			}
		clearNodes(track);
		
		sendMoves((Position[])path.toArray());
	}
	
	/**
	 * This method implements a Breadth First Search algorithm. Given a start and end position (root and target),
	 * the algorithm will search the current branch node for all children nodes, repeating for all branched children nodes,
	 * until the target is found. The updated path ArrayList passes the sequence of positions to a move method which 
	 * calls for a sprite move method.
	 * 
	 * @param root starting node
	 * @param target desired node
	 */
	protected static void BFS(Position root, Position target) {
		root.visited = true;
		
		Set<Position> track = new HashSet<Position>();
		track.add(root);
		
		ArrayList<Position> path = new ArrayList<Position>();
		
		Queue<Position> q = new LinkedList<Position>();
		q.add(root);
		
		search:
			while (!q.isEmpty()) {
				path.clear();
				
				Position n = (Position)q.remove();
				Position child = null;
				
				path.add(n);
				track.add(n);
				
				while ((child = getUnvisitedChildPiece(n)) != null) {
					child.visited = true;
					track.add(child);
					
					path.add(child);
					q.add(child);
					
					if (child.equals(target))
						break search;
				}
			}
		clearNodes(track);
		
		sendMoves((Position[])path.toArray());
	}
	
	/**
	 * This method takes a node position and searches up, down, left, and right for unvisited child nodes,
	 * and passes back a child node that meets those parameters. If no such node exists, returns null.
	 * 
	 * @param parent node position
	 * @return child node position
	 */
	private static Position getUnvisitedChildPiece(Position parent) {
		if (!(BoardState.things.get(Position.getUp(parent)) instanceof Walls) && !(BoardState.things.get(Position.getUp(parent)).whereAmI.visited))
			return BoardState.things.get(Position.getUp(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getDown(parent)) instanceof Walls) && !(BoardState.things.get(Position.getDown(parent)).whereAmI.visited))
			return BoardState.things.get(Position.getDown(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getLeft(parent)) instanceof Walls) && !(BoardState.things.get(Position.getLeft(parent)).whereAmI.visited))
			return BoardState.things.get(Position.getLeft(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getRight(parent)) instanceof Walls) && !(BoardState.things.get(Position.getRight(parent)).whereAmI.visited))
			return BoardState.things.get(Position.getRight(parent)).whereAmI;
		else
			return null;
	}
	
	/**
	 * This method takes an array of positions and calls the move
	 * method to carry out search algorithm pathing.
	 * 
	 * @param path array of positions
	 */
	private static void sendMoves(Position[] path) {
		for (int i = path.length-1; i > 0 ; i--)
			Pacman.move(path[i]);
	}
	
	/**
	 * This method clears all visited nodes of their visited status,
	 * to reopen them for use in later searches.
	 * 
	 * @param track set of all visited nodes
	 */
	private static void clearNodes(Set<Position> track) {
		for (Position p : track)
			p.visited = false;
	}
	
	
}
