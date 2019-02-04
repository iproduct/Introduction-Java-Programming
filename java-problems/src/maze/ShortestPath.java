package maze;

import java.io.File;
import java.io.FileNotFoundException;
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

	public static void main(String[] args) {
		ShortestPath problem = new ShortestPath("maze.txt");
		try {
			problem.readMazeFile();
			System.out.println(problem.getMazeAsString());
			System.out.println("Curiosity position: "+ problem.getCuriosityPosition());
		} catch (InvalidMazeFileFormatException e) {
			System.err.println(e.getMessage());
		}
	}

}
