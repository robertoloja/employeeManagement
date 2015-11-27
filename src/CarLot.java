//TODO: Maybe move this class's main method to UseCarLot.
/**
 * Contains methods to be used on LinkedLists of Car objects.
 * @author Roberto Loja
 * @version November 11 2015
 */
import java.time.Year;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

class CarLot
{
	// Class constants.
	final private static int	MAX_STR_LENGTH = 9;
	final private static int	MIN_YEAR	   = 1800;
	final private static double MAX_PRICE	   = 999999.99;

	/**
	 * Displays all cars in alphabetical order with headings, one line per car.
	 * @param cars A LinkedList containing car objects.
	 */
	public static void displayCars(LinkedList cars)
	{
		Collections.sort(cars);
		ListIterator iterator = cars.listIterator();
		Car cur = null;

		System.out.println();
		System.out.println("+-----------+-----------+-----------+-----------+--"
						 + "---------+");

		System.out.println("|   Model   |  Colour   |   Year    |    VIN    |  "
			             + " Price   |");

		System.out.println("+-----------+-----------+-----------+-----------+--"
				         + "---------+");

		while (iterator.hasNext()) 
		{
			cur = (Car) iterator.next();
			System.out.printf("| %-10s| %-10s| %-10d| %-10d| %-10.2f|\n", 
					cur.getModel(),	cur.getColor(), cur.getYear(), cur.getVin(),
					cur.getPrice());
		}
		System.out.println("+-----------+-----------+-----------+-----------+--"
						 + "---------+");
	}

	/**
	 * Displays car info, given a VIN number.
	 * @param cars A LinkedList containing car objects.
	 * @param vin An int, the VIN to find in cars.
	 */
	public static void infoFromVin(LinkedList cars, int vin)
	{
		Car cur = null;
		boolean found = false;
		ListIterator iter = cars.listIterator();

		while (iter.hasNext() && !found)
		{
			cur = (Car) iter.next();
			if (cur.getVin() == vin)
			{
				found = true;
				System.out.println("+------------------+");
				System.out.printf("| VIN:   %-10d|\n", cur.getVin());
				System.out.printf("| Model: %-10s|\n", cur.getModel());
				System.out.printf("| Color: %-10s|\n", cur.getColor());
				System.out.printf("| Year:  %-10d|\n", cur.getYear());
				System.out.printf("| Price: %-10.2f|\n", cur.getPrice());
				System.out.println("+------------------+");
			}
		}
		if (!found)
			System.out.println("Car with VIN " + vin + " not found.");
	}

	/**
	 * Lists the first two cars of the same model.
	 * @param cars A LinkedList containing car objects.
	 */
	public static void listSameModel(LinkedList cars)
	{
		Car cur = null;
		boolean stop = false;
		ListIterator iter = null;

		// Using a regular for loop gives an index that can be reused.
		for (int i = 0; i < cars.size(); i++) 
		{
			if (!stop)
				iter = cars.listIterator(i + 1); // As max(i + 1) = cars.size(),
			                                     // no exception is thrown.
			while (iter.hasNext() && !stop)
			{
				cur = (Car) iter.next();
				if (((Car) cars.get(i)).compareTo(cur) == 0)
				{
					infoFromVin(cars, ((Car) cars.get(i)).getVin());
					infoFromVin(cars, cur.getVin());
					stop = true;
				}
			}
		}
		if (!stop)
			System.out.println("Could not find two cars of the same model.");
	}

	/**
	 * Updates inventory (adds, deletes, or modifies a car).
	 * Error checking: If input is not in ['a', 'A', 'd', 'D', 'm', 'M'],
	 *				   displays error message and asks for input again.
	 *
	 * @param cars A LinkedList containing car objects.
	 */
	public static void updateInventory(LinkedList cars)
	{
		boolean repeat = true;
		String option = new String();

		while (repeat)
		{
			System.out.printf("\n[A]dd, [d]elete, or [m]odify a car: ");
			option = IO.readString();

			switch (option)
			{
				case "A":
				case "a":
					repeat = false;
					System.out.println("Adding a car to the lot.");
					addCar(cars);
					break;

				case "D":
				case "d":
					repeat = false;
					System.out.println("Deleting a car from the lot.");
					//deleteCar();
					break;

				case "M":
				case "m":
					repeat = false;
					System.out.println("Modifying existing car.");
					//modifyCar();
					break;

				default:
					System.out.println("Please choose one of [a]dd, [d]elete,"
									 + " or [m]odify.");
			}
		}
	}

	/**
	 * Add a car to the lot, with input validation.
	 * Error checking: The usual IO.java input verification. Entered strings 
	 * cannot exceed MAX_STR_LEN, due to how the display methods are formatted.
	 * Year must be between MIN_YEAR and the year after the current one (since 
	 * e.g. 2016 models come out in 2015). Entered VINs cannot match cars 
	 * already in the lot. Price must be less than zero and greater than 
	 * MAX_PRICE, for the sake of display formatting.
	 * @param cars A LinkedList containing car objects.
	 */
	public static void addCar(LinkedList cars)
	{
		int tmpInt = 0;
		double tmpDouble = 0;
		String tmpStr = new String();
		Car newCar = new Car();
		cars.add(newCar);

		boolean repeat = true;
		while (repeat)
		{
			System.out.printf("Model: ");
			tmpStr = IO.readString();

			if (tmpStr.length() > MAX_STR_LENGTH) {
				System.out.println("Maximum length is " + MAX_STR_LENGTH 
						         + " characters.");
			} else {
				repeat = false;
				newCar.setModel(tmpStr);
			}
		}

		repeat = true;
		while (repeat)
		{
			System.out.printf("Color: ");
			tmpStr = IO.readString();

			if (tmpStr.length() > MAX_STR_LENGTH) {
				System.out.println("Maximum length is " + MAX_STR_LENGTH 
						         + " characters.");
			} else {
				repeat = false;
				newCar.setColor(tmpStr);
			}
		}

		repeat = true;
		while (repeat)
		{
			System.out.printf("Year:  ");
			tmpInt = IO.readInt();

			if (tmpInt > Year.now().getValue() + 1 || tmpInt < MIN_YEAR) {
				System.out.println("Car must be from between " + MIN_YEAR 
							     + " and " + (Year.now().getValue() + 1) + ".");
			} else {
				repeat = false;
				newCar.setYear(tmpInt);
			}
		}

		boolean alreadyExists;
		repeat = true;
		while (repeat)
		{
			alreadyExists = false;
			System.out.printf("VIN:   ");
			tmpInt = IO.readInt();

			for (Object car: cars) {
				if (((Car) car).getVin() == tmpInt)
					alreadyExists = true;
			}

			// Separate conditional, so the message will only ever print once,
			// even if there are multiple cars with the same VIN.
			if (alreadyExists) {
				System.out.println("A car with VIN " + tmpInt + " already "
						         + "exists in the lot. Enter different VIN.");
			} else {
				repeat = false;
				newCar.setVin(tmpInt);
			}
		}
		
		repeat = true;
		while (repeat)
		{
			System.out.printf("Price: ");
			tmpDouble = IO.readDouble();

			if (tmpDouble > MAX_PRICE || tmpDouble <= 0) {
				System.out.println("Price must be between 0 and " + MAX_PRICE
						         + ".");
			} else {
				repeat = false;
				newCar.setPrice(tmpDouble);
			}
		}
	}

	/**
	 * Displays the total value of the cars in the lot.
	 * @param cars A LinkedList containing car objects.
	 */
	public static void displayTotalValue(LinkedList cars)
	{
		double sum = 0;
		for (Object car : cars)
			sum += ((Car) car).getPrice();
		System.out.printf("Total value of cars in the lot: $%.2f", sum);
	}

	/**
	 * Shallow clones the list.
	 * @param cars A LinkedList containing car objects.
	 * @return cars.clone(), cast as a LinkedList.
	 */
	public static LinkedList shallowClone(LinkedList cars)
	{
		LinkedList shallowCopy = cars;
		return shallowCopy;
	}

	/**
	 * Deep clones the list.
	 * @param cars A LinkedList containing car objects.
	 * @return A deep copy of cars.
	 */
	public static LinkedList deepClone(LinkedList cars)
	{
		return new LinkedList(cars);
	}

	public static void main(String[] args)
	{
		int choice = 0;
		LinkedList carLot = new LinkedList();

		while (choice != 8)
		{
			choice = Menu.menu();

			switch(choice)
			{
				case 1:
					CarLot.displayCars(carLot);
					break;
				case 2:
					System.out.printf("\nEnter a VIN: ");
					CarLot.infoFromVin(carLot, IO.readInt());
					break;
				case 3:
					CarLot.listSameModel(carLot);
					break;
				case 4:
					CarLot.updateInventory(carLot);
					break;
				case 5:
					CarLot.displayTotalValue(carLot);
					break;
				case 6:
					CarLot.shallowClone(carLot);
					break;
				case 7:
					CarLot.deepClone(carLot);
					break;
				// No need for a default case, as the menu class handles that.
			}
		}
	}
}
