package strings;

import java.util.Random;

public class Poetry {
	public static final String[] nouns = {"Java", "computer", "feeling", "tragedy", "smile", "joy", "program", "instructiuon"};
	public static final  String[] verbs = {"create", "justify", "feel", "see", "cry", "send", "inform", "imagine"};
	public static final String[] adjectives = {"nice", "beautiful", "mighty", "wonderful", "terrible", "comapct", "fast", "smart"};
	public static final String[] props = {"of", "at", "on", "in", "from", "to"};
	
	private static Random rand = new Random();

	public static String getRandomWord(String[] words) {
		int  index = rand.nextInt(words.length);
		return words[index];
	}
	
	
	
	public static void main(String[] args) {
		StringBuilder sb  = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			sb.append(getRandomWord(nouns)).append(" ")
			.append(getRandomWord(verbs)).append(" ")
			.append(rand.nextInt(2) > 0 ? getRandomWord(props) : "").append(" ")
			.append(rand.nextInt(2) > 0 ? getRandomWord(adjectives) : "").append(" ")
			.append(getRandomWord(nouns))
			.append("\n");
		}
		System.out.println(sb.toString());
		

	}

}
