package statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TextStatistics {
	private static List<String> banList = Arrays.asList(new String[] {
			"a", "in", "of", "from", "to", "and", "that", "the", "was", "are", "is"
	});
	private static Scanner sc = new Scanner(System.in);
	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void inputText() {
		System.out.print("Text: ");
		text = sc.nextLine();
	}
	
	public static String[] getAllWords(String text) {
		return text.split("[\\.,!-+?\\s]*(\\[\\d+\\])?[\\.,!-+?\\s]+");
	}
	
	public static WordCount[] getWordsCount(String text) {
		String[] words = getAllWords(text); //get all words
		WordCount[] counts = new WordCount[words.length];
		int counter = 0;

		for(String word: words) {
			boolean isFound = false;
			for(int i = 0; i < counter; i++) {
				if(word.equals(counts[i].getWord())) {
					counts[i].setCount(counts[i].getCount() + 1);
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				counts[counter++] = new WordCount(word, 1);
			}
		}
		return Arrays.copyOf(counts, counter);
	}

	public static List<WordCount> getWordsCount2(String text) {
		List<String> words = Arrays.asList(getAllWords(text)); //get all words
		List<WordCount> counts = new ArrayList<>();

		for(String word: words) {
			boolean isFound = false;
			for(WordCount wc: counts) {
				if(word.equals(wc.getWord())) {
					wc.setCount(wc.getCount() + 1);
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				counts.add(new WordCount(word, 1));
			}
		}
		Collections.sort(counts);
		return counts;
	}
	
	public static List<WordCount> filterTopTenWords(List<WordCount> source) {
		List<WordCount> result = new ArrayList<>();
		for(WordCount wc: source) {
			if(wc.getWord().length() > 1 && !banList.contains(wc.getWord().toLowerCase())) {
				result.add(wc);
				if(result.size() >= 10) {
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TextStatistics ts = new TextStatistics();
		ts.inputText();
		System.out.println();
		for(WordCount wc: filterTopTenWords(getWordsCount2(ts.getText()))) {
			System.out.println(wc);
		}
	}
}
