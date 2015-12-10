import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains an ArrayList of Employee objects and the methods to access or 
 * manipulate that list.
 * @author Roberto Loja
 * @version November 30 2015
 */
class Company
{
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	// Class constants. Used for input validation.
	private static final String[] VALID_DEPTS = {"Operations", "Development", "Quality Assurance"};
	private static final String[] VALID_TERRITORIES = {"North", "South", "West", "East"};
	private static final int MAX_LEVEL = 3;

	// Calling nextEmpNum() returns a unique employee number.
	private int empNum = 0;
	private int nextEmpNum() 
	{ 
		if (empNum == 0)
		{
			// Find highest employee number previously assigned.
			for (Employee emp : employees)
			{
				if (emp.getNumber() > empNum)
					empNum = emp.getNumber();
			}
		}
		return ++empNum; 
	}


	/**
	 * Constructor. Calls resetList().
	 */
	public Company()
	{
		this.resetList();
	}

	/**
	 * Resets the ArrayList employees to its initial state.
	 */
	public void resetList()
	{
		// Clear the list.
		employees.clear();

		// Reset employee numbers.
		empNum = 1;

		// Default employees.
		employees.add(new Salesman("Shirley", nextEmpNum(), 500, "North"));
		employees.add(new Salesman("Jeff", nextEmpNum(), 800, "East"));
		employees.add(new Salesman("Frank", nextEmpNum(), 900, "West"));
		employees.add(new Salesman("George", nextEmpNum(), 750, "West"));
		employees.add(new Salesman("Lisa", nextEmpNum(), 750, "South"));
		employees.add(new Technician("John", nextEmpNum(), 3, "Operations"));
		employees.add(new Technician("Anne", nextEmpNum(), 3, "Development"));
		employees.add(new Technician("Troy", nextEmpNum(), 2, "Development"));
		employees.add(new Technician("Mark", nextEmpNum(), 1, "Quality Assurance"));
		employees.add(new Technician("Jessica", nextEmpNum(), 2, "Quality Assurance"));
	}

	/**
	 * Sort employees by Employee number.
	 */
	public void sortList()
	{
		Collections.sort(employees);
	}

	/**
	 * Adds an employee to ArrayList employees. Parameter type must be "t" or
	 * "s", territory must be present in VALID_TERRITORIES, department must be
	 * present in VALID_DEPTS, level must be greater than 0 and less than 
	 * MAX_LEVEL. If any of the above conditions are not met, method returns 
	 * an error code. -1 means the employee type does not exist, 1 means a
	 * parameter was invalid. 
	 * @param type The type of employee (e.g. s for Salesman).
	 * @param name Employee name.
	 * @param territory If type.equals("s"), this is the employee's territory.
	 * @param department If type.equals("T"), this is the employee's department.
	 * @param level If type.equals("T"), this is the employee's level.
	 * @param salesTarget If type.equals("S"), this is the sales target.
	 * @return 0 if employee is successfully added to ArrayList employees.
	 */
	public int addEmployee(String type, String name, String territory, 
			String department, int level, double salesTarget)
	{
		int value = 0;
		if (type.equalsIgnoreCase("t"))
		{
			// Add a technician with error checking.
			if (validateString(VALID_DEPTS, department) && 
					(level > 0 && level <= MAX_LEVEL)) 
			{
				Technician tech = new Technician(name, nextEmpNum(), level,
						department);
				employees.add(tech);

			} else {
				// ERROR: A parameter could not be validated.
				value = 1;
			}

		} else if (type.equalsIgnoreCase("s")) {
			// Add a salesman with error checking.
			if (validateString(VALID_TERRITORIES, territory))
			{
				Salesman sm = new Salesman(name, nextEmpNum(), salesTarget,
						territory);
				employees.add(sm);
			} else {
				// ERROR: A parameter could not be validated.
				value = 1;
			}
		} else {
			// ERROR: This type of employee doesn't exist.
			value = -1;
		}
		return value;
	}

	/**
	 * Deletes specified employee from ArrayList employees.
	 * @param employeeNumber The number of the employee to be deleted.
	 * @return 0 if successful, -1 if specified employee could not be found.
	 */
	public int deleteEmployee(int employeeNumber)
	{
		boolean found = false;
		int value = 0;
		int i = 0;

		while (!found && i < employees.size())
		{
			if (employees.get(i).getNumber() == employeeNumber)
			{
				employees.remove(i);
				found = true;
			}
			i++;
		}

		if (!found)
			value = -1;

		return value;
	}

	/**
	 * Checks if a given string is present in a given set. Used to validate
	 * strings passed to addEmployee().
	 * @param validSet An array of permitted Strings, likely a class constant.
	 * @param toValidate The String to be validated.
	 * @return True if toValidate is permitted, false otherwise.
	 */
	private boolean validateString(String[] validSet, String toValidate)
	{
		boolean validated = false;

		for (String item : validSet)
		{
			if (item.equals(toValidate))
				validated = true;
		}

		return validated;
	}

	// Getter for ArrayList employees.
	public ArrayList<Employee> getEmployees() { return employees; }
	public String[] getValidDepts() { return VALID_DEPTS; }
	public String[] getValidTerritories() { return VALID_TERRITORIES; }
	public int getMaxLevel() { return MAX_LEVEL; }
}
