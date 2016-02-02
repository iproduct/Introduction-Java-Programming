package hello;

public class SimpleExample {

	public static void main(String[] args) {
		String s; //declare
		s = new String("Trayan"); //initialize
		Character c = 'a';
		String congratulation = "Hello, "; //declare & initialize
		System.out.println(c+ "." + congratulation + s);
		
		Person p1 = new Person();
		p1.setName ("Ivan Petrov");
		p1.setAge(25);
		System.out.println(p1.getName() + ", " + p1.getAge() );


	}

}
