package simplebrowser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleBrowser {
	private String fileName;
	List<String> lines = new ArrayList<>();
	
	public SimpleBrowser(String htmlFile) {
		fileName = htmlFile;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

//	public void readFile() throws FileNotFoundException {
//		Scanner sc = new Scanner(new File(fileName));
//		while(sc.hasNextLine()) {
//			lines.add(sc.nextLine());
//		}
//		sc.close();
//	}
	
	public void readFileOld() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + getFileName());
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}
	
	public void readFile() {
		try ( Scanner sc = new Scanner(new File(fileName)) ) {
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + getFileName());
		}
	}
	
	public String render() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < lines.size(); i++) {
			String parsedLine = lines.get(i).replaceAll("<[^>]*>", "").trim();
			if(parsedLine.length() > 0) {
				result.append(parsedLine).append("\n");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		SimpleBrowser browser = new SimpleBrowser("index.html");
		browser.readFile();
		System.out.println(browser.render());
		
//		try {
//			browser.readFile();
//			System.out.println(browser.render());
//		} catch(FileNotFoundException ex) {
//			System.err.println("File not found: " + browser.getFileName());
//		}
	}

}
