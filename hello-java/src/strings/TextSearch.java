package strings;

import java.util.Arrays;

public class TextSearch {
	public static final int MAX_RESULTS = 100;
	
	public static final String TEXT = 
			"Builder pattern\r\n" + 
			"From Wikipedia, the free encyclopedia\r\n" + 
			"The builder pattern is an object creation software design pattern. Unlike the abstract factory pattern and the factory method pattern whose intention is to enable polymorphism, the intention of the builder pattern is to find a solution to the telescoping constructor anti-pattern[citation needed] that occurs when the increase of object constructor parameter combination leads to an exponential list of constructors. Instead of using numerous constructors, the builder pattern uses another object, a builder, that receives each initialization parameter step by step and then returns the resulting constructed object at once.\r\n" + 
			"\r\n" + 
			"The builder pattern has another benefit: It can be used for objects that contain flat data (HTML code, SQL query, X.509 certificate…), that is to say, data that can't be easily edited step by step and hence must be edited at once.[citation needed]\r\n" + 
			"\r\n" + 
			"Builder often builds a Composite. Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as the designer discovers where more flexibility is needed. Sometimes creational patterns are complementary: Builder can use one of the other patterns to implement which components are built. Builders are good candidates for a fluent interface.[1][better source needed]\r\n" + 
			"\r\n" + 
			"Contents  [hide] \r\n" + 
			"1	Overview\r\n" + 
			"2	Definition\r\n" + 
			"3	Advantages\r\n" + 
			"4	Disadvantages\r\n" + 
			"5	Structure\r\n" + 
			"5.1	UML class and sequence diagram\r\n" + 
			"5.2	Class diagram\r\n" + 
			"6	Pseudocode\r\n" + 
			"7	Examples\r\n" + 
			"7.1	C#\r\n" + 
			"7.2	C++\r\n" + 
			"7.3	Crystal\r\n" + 
			"7.4	F#\r\n" + 
			"7.5	Java\r\n" + 
			"7.6	Scala\r\n" + 
			"7.7	Python\r\n" + 
			"8	See also\r\n" + 
			"9	References\r\n" + 
			"10	External links\r\n" + 
			"Overview[edit]\r\n" + 
			"The Builder design pattern is one of the twenty-three well-known GoF design patterns[2] that describe how to solve recurring design problems to design flexible and reusable object-oriented software, that is, objects that are easier to implement, change, test, and reuse.\r\n" + 
			"\r\n" + 
			"The Builder design pattern solves problems like:[3]\r\n" + 
			"\r\n" + 
			"How can a class (the same construction process) create different representations of a complex object?\r\n" + 
			"How can a class that includes creating a complex object be simplified?\r\n" + 
			"Creating and assembling the parts of a complex object directly within a class is inflexible. It commits the class to creating a particular representation of the complex object and makes it impossible to change the representation later independently from (without having to change) the class.\r\n" + 
			"\r\n" + 
			"The Builder design pattern describes how to solve such problems:\r\n" + 
			"\r\n" + 
			"Encapsulate creating and assembling the parts of a complex object in a separate Builder object.\r\n" + 
			"A class delegates object creation to a Builder object instead of creating the objects directly.\r\n" + 
			"A class (the same construction process) can delegate to different Builder objects to create different representations of a complex object.\r\n" + 
			"See also the UML class and sequence diagram below.\r\n" + 
			"\r\n" + 
			"Definition[edit]\r\n" + 
			"The intent of the Builder design pattern is to separate the construction of a complex object from its representation. By doing so the same construction process can create different representations.[2]\r\n" + 
			"\r\n" + 
			"Advantages[edit]\r\n" + 
			"Advantages of the Builder pattern include:[4]\r\n" + 
			"\r\n" + 
			"Allows you to vary a product’s internal representation.\r\n" + 
			"Encapsulates code for construction and representation.\r\n" + 
			"Provides control over steps of construction process.\r\n" + 
			"Disadvantages[edit]\r\n" + 
			"Disadvantages of the Builder pattern include:[4]\r\n" + 
			"\r\n" + 
			"Requires creating a separate ConcreteBuilder for each different type of Product.\r\n" + 
			"Requires the builder classes to be mutable.\r\n" + 
			"Data members of class aren't guaranteed to be initialized.\r\n" + 
			"Dependency injection may be less supported.";
	
	public static String[] findOccurences(String query, boolean isCaseSensitive ) {
		String[] results = new String[MAX_RESULTS];
		int numResults = 0;
		String[] paragraphs = TEXT.split("\r\n");
		System.out.println("Lines: " + paragraphs.length);
		int n = 0;
		if(!isCaseSensitive) {
		 query = query.toLowerCase();
		}
		
//		for(String line: paragraphs) {
//			System.out.println(++n + ": " + line);
//		}
		
		for(String line: paragraphs) {
			line = line.trim();
			String str = line;
			if(str.length() > 0) {
				if(!isCaseSensitive) {
					str = str.toLowerCase();
				} 
				int index = str.indexOf(query);
				if(index >= 0) {
					StringBuilder sb = new StringBuilder(line);
					while(index >= 0) {
						sb.replace(index, index + query.length(), query.toUpperCase());
						index = str.indexOf(query, index + query.length());
					}
					results[numResults++] = sb.toString();
				}
			}
		}
		return Arrays.copyOfRange(results, 0, numResults);
	}

	public static void main(String[] args) {
		String[] results = findOccurences("Builder", false);
		int n = 0;
		
		// Print found lines containing query string
		for(String result: results)
			System.out.println(++n + ": " + result);
	}

}
