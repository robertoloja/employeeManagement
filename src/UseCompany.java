/**
 * Test class for Company.java
 * @author
 * @version
 */
class UseCompany
{
	public static void main(String argv[])
	{
		System.out.println("Call constructor and display default list: ");
		Company company = new Company();

		for (Employee emp : company.getEmployees())
			System.out.println(emp);

		System.out.println();
		System.out.println("Add employee and display list again:");
		company.addEmployee("T", "NEW NAME", "", "Operations", 3, 0);

		for (Employee emp : company.getEmployees())
			System.out.println(emp);

		System.out.println();
		System.out.println("Try to add Salesman with territory=\"Canada\":");
		if (company.addEmployee("S", "BAD DATA", "Canada", "", 0, 1000) == 1)
			System.out.println("Failed.");
		else
			System.out.println("Succeeded");

		System.out.println();
		System.out.println("Try to add an employee of type \"Manager\":");
		if (company.addEmployee("Manager", "BAD DATA", "", "", 0, 1000) == -1)
			System.out.println("Failed.");
		else
			System.out.println("Succeeded");

		System.out.println();
		System.out.println("Remove employee with ID number 8, display again:");
		company.deleteEmployee(8);

		for (Employee emp : company.getEmployees())
			System.out.println(emp);

		System.out.println();
		System.out.println("Reset list and display:");
		company.resetList();

		for (Employee emp : company.getEmployees())
			System.out.println(emp);
	}
}
