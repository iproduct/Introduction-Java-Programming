package hello;

/** This class models a single person entity.
 * It includes information about person's 
 * name and age.
 * 
 * @author Trayan Iliev
 * @see hello.SimpleExample#main(String[])
 *
 */
public class Person {
	private String name;
	private int age;
	
	/**
	 * Returns the name of the person
	 * @return person's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Modifies name of the person
	 * @param aName modified person's name
	 */
	public void setName(String aName){
		name = aName;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int anAge) {
		age = anAge;	
	}

	/**
	 * Demonstrates {@link Person} class functionality
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "Ivan Petrov";
		p1.age = 25;
		System.out.println(p1.name + ", " + p1.age );

	}


}
