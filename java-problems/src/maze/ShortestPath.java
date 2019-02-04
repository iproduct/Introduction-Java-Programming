package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {
	private char[][] maze;
	private int mazeSize;
	private String mazeFileName;
	
	public ShortestPath(String mazeFile) {
		mazeFileName = mazeFile;
	}
	
	public void readMazeFile() throws InvalidMazeFileFormatException {
		try (Scanner sc = new Scanner(new File(mazeFileName))) {
			String  line = sc.nextLine();
			mazeSize = Integer.parseInt(line);
			maze = new char[mazeSize][];
			for(int i = 0; i < mazeSize; i++) {
				if (sc.hasNextLine()) {
					line = sc.nextLine();
					maze[i] = line.toCharArray();
				} else {
					throw new InvalidMazeFileFormatException("Error reading line " + i);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + mazeFileName);
		} 
	}
	
	public String getMazeAsString() {
		StringBuilder sb = new StringBuilder();
		for(char[] line: maze) {
			sb.append(line).append("\n");
		}
		return sb.toString();
	}
	
	public Position getCuriosityPosition() {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == '*') {
					return new Position(j, i);
				}
			}
		}
		return null;
	}
	
	public List<Position> findShortestPath(Position start) {
		Scanner sc = new Scanner(System.in);
		LinkedList<List<Position>> queue = new LinkedList<>();
		LinkedList<Position> initialPath = new LinkedList<>();
		initialPath.add(start);
		queue.offer(initialPath);
		
		while(!queue.isEmpty()) {
			List<Position> nextPath = queue.pollFirst();
			Position last = nextPath.get(nextPath.size() - 1);
			int x = last.getX();
			int y = last.getY();

			if (x < 1 || x >= mazeSize-1 || y < 1 || y >= mazeSize-1) {
				return nextPath;
			}
			if (maze[y][x - 1] == '0') {
				maze[y][x - 1] =  (char)('0' + nextPath.size());
				LinkedList<Position> newPath = new LinkedList<>(nextPath);
				newPath.add(new Position(x-1, y));
				queue.offer(newPath);
			}
			if (maze[y][x + 1] == '0') {
				maze[y][x + 1] =  (char)('0' + nextPath.size());
				LinkedList<Position> newPath = new LinkedList<>(nextPath);
				newPath.add(new Position(x + 1, y));
				queue.offer(newPath);
			}
			if (maze[y - 1][x] == '0') {
				maze[y - 1][x] =  (char)('0' + nextPath.size());
				LinkedList<Position> newPath = new LinkedList<>(nextPath);
				newPath.add(new Position(x, y - 1));
				queue.offer(newPath);
			}
			if (maze[y + 1][x] == '0') {
				maze[y + 1][x] =  (char)('0' + nextPath.size());
				LinkedList<Position> newPath = new LinkedList<>(nextPath);
				newPath.add(new Position(x, y + 1));
				queue.offer(newPath);
			}
			System.out.println(getMazeAsString());
			sc.nextLine();
		}
		return null;
	}

	public static void main(String[] args) {
		ShortestPath problem = new ShortestPath("maze.txt");
		try {
			problem.readMazeFile();
			System.out.println(problem.getMazeAsString());
			Position start = problem.getCuriosityPosition();
			System.out.println("Curiosity position: "+ start);
			System.out.println(problem.findShortestPath(start));
			
		} catch (InvalidMazeFileFormatException e) {
			System.err.println(e.getMessage());
		}
	}

}
