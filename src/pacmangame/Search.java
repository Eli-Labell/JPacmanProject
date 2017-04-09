package pacmangame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Search {

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
	
	@SuppressWarnings("unused")
	private void CSF() {
		
	}
	
	private static Position getUnvisitedChildPiece(Position parent) {
		if (!(BoardState.things.get(Position.getUp(parent)) instanceof Walls) && !(BoardState.things.get(Position.getUp(parent))).whereAmI.visited)
			return BoardState.things.get(Position.getUp(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getDown(parent)) instanceof Walls) && !(BoardState.things.get(Position.getDown(parent))).whereAmI.visited)
			return BoardState.things.get(Position.getDown(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getLeft(parent)) instanceof Walls) && !(BoardState.things.get(Position.getLeft(parent))).whereAmI.visited)
			return BoardState.things.get(Position.getLeft(parent)).whereAmI;
		else if (!(BoardState.things.get(Position.getRight(parent)) instanceof Walls) && !(BoardState.things.get(Position.getRight(parent))).whereAmI.visited)
			return BoardState.things.get(Position.getRight(parent)).whereAmI;
		else
			return null;
	}
	
	private static void sendMoves(Position[] path) {
		for (int i = path.length-1; i > 0 ; i--)
			Pacman.move(path[i]);
	}
	
	private static void clearNodes(Set<Position> track) {
		for (Position p : track)
			p.visited = false;
	}
	
	
}
