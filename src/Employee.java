/**
 * This is the superclass Employee. It contains the general information for
 * SalesMan and Technician
 */
import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable
{
	// Auto generated serialVersionUID.
	private static final long serialVersionUID = 1885732714722332776L;

	private String name;					// Name of employee
	private int number;						// Employee number.
	
	/**
	 * Constructor.
	 * @param nom Name of the employee
	 * @param number Employee number
	 */
	public Employee(String nom, int number )
	{
		name = nom;
		this.number = number;
	}

	/**
	 * Method for comparison of objects.
	 * @param Employee object
	 * @return An integer to indicate comparison  
	 */
	public int compareTo(Employee o)
	{
		return this.getName().compareToIgnoreCase(((Employee) o).getName());
	}
	
	/**
	 * Returns a String of format 
	 * "name, ID: number".
	 * @return A String.
	 */
	public String toString()
	{
		return this.name + ", ID: " + this.number;
	}
	
	// getters and setters 
	public String getName()	{ return this.name;	}
	public int getNumber()  { return this.number; }
	public void setName(String name)	{ this.name = name; }
	public void setNumber(int number)	{ this.number = number; }
}