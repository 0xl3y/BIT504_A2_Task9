package Model;		// Declaring this class is in the 'Model' Package

public class Member {		// Defines a class called Member
	private String id;		// Member ID
	private String firstName;		// Members First Name
	private String lastName;		// Members Last Name
	private int age;				// Members Age
	
	public Member(String id, String firstName, String lastName, int age) {		// Constructor to create a new Member with the provided details
		this.id = id;					// Assigns the ID
		this.firstName = firstName;		// Assigns the first name 
		this.lastName = lastName;		// Assigns the last name
		this.age = age;					// Assigns the age
	}
	
	// Getter method to return the ID
	public String getId() {
		return id;
	}
	
	// Getter method to return the first name
	public String getFirstName() {
		return firstName;
	}
	
	// Getter method to return the last name
	public String getLastName() {
		return lastName;
	}
	
	// Getter method to return the age
	public int getAge() {
		return age;
	}
	
	//  Method to return the full name (first and last)
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public static String getHeader() {			// Static method returning a formatted header string for displaying members
		return String.format("%-5s %-12s %-12s %-3s", "ID", "First name", "Last Name", "Age");
	}
	
	// Overrides the default toString method to return a nicely formatted member string
	@Override
	public String toString() {
		return String.format ("%-5s %-12s %-12s %-3d", id, firstName, lastName, age);	
	}
}