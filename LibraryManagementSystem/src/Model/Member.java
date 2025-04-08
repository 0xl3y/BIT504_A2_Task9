package Model;

public class Member {
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Member(String id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return String.format ("%-5s %-12s %-12s %-3d", id, firstName, lastName, age);	
	}
}