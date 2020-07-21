import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String first_name;
	private String last_name;
	
	/**
	 * Default constructor for Employee
	 */
	Employee() 
	{
		ID = 0;
		first_name = null;
		last_name = null;
	}
	
	/**
	 * Argument constructor for Employee
	 * @param ID the employee ID to set
	 * @param f_name the employee's first name
	 * @param l_name the employee's last name
	 */
	Employee(int ID, String f_name, String l_name) 
	{
		this.setFirst_name(f_name);
		this.setID(ID);
		this.setLast_name(l_name);	
	}

	/**
	 * Access employee's ID
	 * @return the employee's ID
	 */
	public int getID() 
	{
		return ID;
	}

	/**
	 * Set the employee's ID
	 * @param ID the ID to set of type int
	 */
	public void setID(int ID) 
	{
		this.ID = ID;
	}
	
	/**
	 * Access employee's first name
	 * @return employee's first name
	 */
	public String getFirst_name() 
	{
		return first_name;
	}

	/**
	 * Modify employee's first name
	 * @param f_name what to set the first name as type String
	 */
	public void setFirst_name(String f_name) 
	{
		this.first_name = f_name;
	}

	/**
	 * Access the employee's last name
	 * @return the employee's last name
	 */
	public String getLast_name() 
	{
		return last_name;
	}

	/**
	 * Modify employee's last name
	 * @param l_name sets last name of type String
	 */
	public void setLast_name(String l_name) 
	{
		this.last_name = l_name;
	}
	
	/**
	 * The formatted employee information that returns a String
	 */
	public String toString()
	{
		return "Employee ID: " + ID + "\nName: " + last_name + ", " + first_name + "\n";
	}
	
	/**
	 * The overridden equals method for Employees
	 */
	public boolean equals (Object other)
	{
		if(this == other) 
		{
			return true;
		}
		if(other == null) 
		{
			return false;
		}
		if(!(other instanceof Employee )) 
		{
			return false;
		}
	
		Employee emp = (Employee)other;
		return first_name.equals(emp.first_name) && last_name.equals(emp.last_name) && ID == emp.ID;
		
	}
	
	/**
	 * Hash code given to us that assigns same hash code to equal objects
	 */
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * first_name.hashCode() + last_name.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer)ID).hashCode();
		return h;
	}
	/*
	 * The comparable interface is overridden with the compareTo method
	 * Compare the employee's last name first, then their first name, and
	 * lastly their ID to order Employees
	 */
	@Override
	public int compareTo(Employee emp) {
		if(last_name.compareTo(emp.last_name) > 0)
		{
			return 1;
		}
		
		else if(last_name.compareTo(emp.last_name) < 0)
		{
			return -1;
		}
		
		else
		{
			if(first_name.compareTo(emp.first_name) > 0) 
			{
				return 1;
			}
			 
			else if(first_name.compareTo(emp.first_name) < 0)
			{
				 return -1;
			}
			 
			else 
			{
				 if(ID > emp.ID) 
				 {
					 return 1;
				 }
				 
				 else if(ID < emp.ID) 
				 {
					 return -1;
				 }
				 
				 else 
				 {
					return 0; 
				 }
			 }
		}
	}
}
