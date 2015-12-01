/**
 * The Salesman class extends Employee, providing a specialized toString()
 * and constructor.
 * @author Roberto Loja
 * @version November 20, 2015
 */
class Salesman extends Employee
{
	// Auto generated serialVersionUID.
	private static final long serialVersionUID = 68115552796680647L;
	private double salesTarget;
	private String territory;

	/**
	 * Default constructor, takes no parameters, calls Employee's constructor
	 * with params name = "no name", employee number = 0. Used to create 
	 * placeholder Salesman objects.
	 */
	public Salesman()
	{
		super("no name", 0);
	}

	/**
	 * Complete constructor.
	 * @param nom Salesman's name.
	 * @param number Salesman's employee number.
	 * @param target Salesman's sales target.
	 * @param territory Salesman's operating territory.
	 */
	public Salesman(String nom, int number, double target, String territory)
	{
		super(nom, number);
		this.salesTarget = target;
		this.territory = territory;
	}

	@Override
	public String toString()
	{
		return super.toString() + ", salesman in " + territory + ". "
			   + "Sales target: " + salesTarget;
	}

	// Getters and setters
	public void setSalesTarget(double target)  { this.salesTarget = target; }
	public void setTerritory(String territory) { this.territory = territory; }

	public double getSalesTarget() { return this.salesTarget; }
	public String getTerritory()   { return this.territory; }
}
