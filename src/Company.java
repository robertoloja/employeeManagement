// TODO: Finish addEmployee.
import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains an ArrayList of Employee objects and the methods to access or 
 * manipulate that list.
 * @author Roberto Loja
 * @version November 11 2015
 */
class Company
{
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	// Class constants. Used for input validation.
	private static final String[] validDepts = {"Operations", "Development",
												"Quality Assurance"};
	private static final String[] validTerritories = {"North", "South",
													  "West", "East"};
	private static final int[] validLevels = {1, 2, 3};

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
		int empNum = 1;

		// Clear the list.
		for (Object emp : employees)
			employees.remove(emp);

		// Default employees.
		employees.add(new Salesman("Shirley", empNum++, 500, "North"));
		employees.add(new Salesman("Jeff", empNum++, 800, "East"));
		employees.add(new Salesman("Frank", empNum++, 900, "West"));
		employees.add(new Salesman("George", empNum++, 750, "West"));
		employees.add(new Salesman("Lisa", empNum++, 750, "South"));
		employees.add(new Technician("John", empNum++, 3, "Operations"));
		employees.add(new Technician("Anne", empNum++, 3, "Development"));
		employees.add(new Technician("Troy", empNum++, 2, "Development"));
		employees.add(new Technician("Mark", empNum++, 1, "QA"));
		employees.add(new Technician("Jessica", empNum++, 2, "QA"));
	}

	/**
	 * Sort employees by Employee number.
	 */
	public void sortList()
	{
		Collections.sort(employees);
	}

	public int addEmployee(String type, String name, String territory, 
			String department, int level, double salesTarget)
	{
		int value = 0;
		if (type.equalsIgnoreCase("t"))
		{
			// Add a technician with error checking.
			if (validateString(validDepts, department)) 
			{
				employees.add(new Technician());
				employees.get(employees.size()).setName(name);

				((Technician)employees.get(employees.size()))
									.setDepartment(department);

				((Technician)employees.get(employees.size()))
									.setDepartment(department);
			} else {
				value = -1;
			}

		} else if (type.equalsIgnoreCase("s")) {
			// Add a salesman with error checking.
		} else {
			// ERROR: This type of employee doesn't exist.
			value = -1;
		}
		return value;
	}

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
}
