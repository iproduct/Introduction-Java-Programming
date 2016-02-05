package hello;

/**
 * Simple Java programming examples:
 * <ol>
 * <li>Declaring and initializing objects and primitives</li>
 * <li>Using other objects by calling {@link Person#getName() getter} and
 * {@link Person#setName(String) setter} methods.
 * </ol>
 * 
 * @author Trayan Iliev
 * @see Person
 * @version 1.0.0
 * @since 0.2.1
 * 
 */
public class SimpleExample {

	public static void main(String[] args) {
		String s; // declare
		s = new String("Trayan"); // initialize
		Character c = 'a';
		String congratulation = "Hello, "; // declare & initialize
		System.out.println(c + "." + congratulation + s);

		Person p1 = new Person();
		p1.setName("Ivan Petrov");
		p1.setAge(25);
		System.out.println(p1.getName() + ", " + p1.getAge());

	}

}
