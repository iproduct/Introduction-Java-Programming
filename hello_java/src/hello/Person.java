package hello;

public class Person {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String aName){
		name = aName;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int anAge) {
		age = anAge;	
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "Ivan Petrov";
		p1.age = 25;
		System.out.println(p1.name + ", " + p1.age );

	}


}
