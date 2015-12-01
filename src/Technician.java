/**
 * The Technician class extends Employee, providing a specialized toString()
 * and constructor.
 * @author Roberto Loja
 * @version November 20, 2015
 */
class Technician extends Employee
{
	// Auto generated serialVersionUID.
	private static final long serialVersionUID = 7103581497297119247L;
	private int level;
	private String department;

	/**
	 * Default constructor, takes no parameters, calls Employee's constructor
	 * with params name = "no name", employee number = 0. Used to create 
	 * placeholder Technician objects.
	 */
	public Technician()
	{
		super("no name", 0);
	}

	/**
	 * Full constructor.
	 * @param nom Technician's name.
	 * @param number Technician's employee number.
	 * @param level Technician's level.
	 * @param dept Technician's department.
	 */
	public Technician(String nom, int number, int level, String dept)
	{
		super(nom, number);
		this.level = level;
		this.department = dept;
	}

	@Override
	public String toString()
	{
		return super.toString() + ", technician in " + department + ". "
			   + "Level: " + level;
	}

	// Getters and setters
	public void setLevel(int level)		   { this.level = level; }
	public void setDepartment(String dept) { this.department = dept; }

	public int getLevel()		  { return this.level; }
	public String getDepartment() { return this.department; }
}
