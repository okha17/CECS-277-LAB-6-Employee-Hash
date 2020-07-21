import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.*;

public class Tester 
{
	@SuppressWarnings("unchecked")
	public static void main (String[] args)  throws FileNotFoundException, IOException, ClassNotFoundException
	{ 
		Map<Integer, Employee> employee_map;
		Map<Employee, Integer> grade_map;
		File f = new File("Employee.dat");
		f.createNewFile();
		
		if(f.exists())
		{ 	
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			employee_map = (Map<Integer, Employee>) in.readObject();
			grade_map = (Map<Employee, Integer>) in.readObject();
			in.close();
		}
		
		else
		{
			employee_map = new HashMap<Integer, Employee>();
			grade_map = new HashMap<Employee, Integer>();
		}
			
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		int choice = 0;
		while (choice != 5) 
		{
			printMenuAndGetChoice();
			choice = in.nextInt();	
			switch (choice)
			{
			case 1:
				add(employee_map, grade_map);
				break;
			case 2:
				remove(employee_map, grade_map);
				break;
			case 3:
				update(employee_map, grade_map);
				break;
			case 4:
				display(grade_map);
				break;
			case 5:
				System.out.println("\nQuitting Menu!");
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
				out.writeObject(employee_map);
				out.writeObject(grade_map);
				out.close();
				break;
			default:
				System.out.println("Incorrect choice \nTry again!\n");
			}
		}
	}
	
	
	/**
	 * Method that prints the menu and returns nothing
	 */
	public static void printMenuAndGetChoice()
	{
		System.out.println("Employee Mapping: \n");
		System.out.println(" 1) Add an employee\n 2) Remove an employee\n 3) Update employee\n 4) Display employees\n 5) Quit\n");
		System.out.println("Enter your choice: ");
	}
	
	
	/**
	 * Method to add a new employee to the map that also checks for duplicates
	 * users enter employee name and performance while hash code generates ID
	 * @param em The employee map that has employee ID as its key
	 * @param gm The grade map that has employee objects as its key
	 */
	public static void add(Map<Integer, Employee> em, Map<Employee, Integer> gm)
	{		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Last Name: ");
		String last = in.next();	
		System.out.print("First Name: ");
		String first = in.next();
		System.out.print("Enter an ID: ");
		int ID = in.nextInt();
        System.out.print("Employee grade between 1-5: ");
		int grade = 0;
		int i = 0;
		
		while (i < 1)
		{
			int value = in.nextInt();
			if(value >= 1 && value <= 5)
	        {
	            grade = value;
	            i++;
	        }
	        else 
	        {
	        	System.out.println("\nIncorrect grade entered! \nPlease enter again: ");
	        }
		}
        
        Employee emp = new Employee(ID, first, last);
        Set<Employee> keys = gm.keySet();
        
        for(Employee empl: keys)  //advanced for loop
        {
        	if(empl.equals(emp))
        	{
        		System.out.println("Duplicate employee already in Map" + "\n");
        		break;
        	}
        }
        gm.put(emp, grade);
        em.put(ID, emp);
	}
	
	/**
	 * The removed method that removes an employee from both maps by user input
	 * based on employee ID
	 * @param em The employee map
	 * @param gm The grade map
	 */
	public static void remove(Map<Integer, Employee> em, Map<Employee, Integer> gm)
	{
		System.out.println("Enter employee ID to remove:");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int emp_ID = in.nextInt();
		if(em.containsKey(emp_ID))
		{
			System.out.println("\nRemoved Employee: " + (em.get(emp_ID)).toString() + "\n");
			gm.remove(em.get(emp_ID));
			em.remove(emp_ID);
		}
			
		else 
		{
			System.out.println("Incorrect ID, employee does not exist!" + "\n");
		}
	}
	
	
	/**
	 * The update method modifies the employee grade based off user input
	 * Checks if employee is in the map before asking for new grade
	 * @param em The employee map used to check for employee ID
	 * @param gm The new grade is stored the grade map
	 */
	public static void update(Map<Integer, Employee> em, Map<Employee, Integer> gm)
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter ID number for employee: ");
		int emp_ID = in.nextInt();
		
		if(em.containsKey(emp_ID)) 
		{
			System.out.println("Enter employee's updated grade: ");
			int grade = 0;
			int i = 0;
			
			while (i < 1)
			{
				int value = in.nextInt();
				if(value >= 1 && value <= 5)
		        {
		            grade = value;
		            i++;
		        }
		        else 
		        {
		        	System.out.println("\nIncorrect grade entered! \nPlease enter again: ");
		        }
			}
	        
			gm.put(em.get(emp_ID), grade);
		}
		else
		{
			System.out.println("The employee does not exist \n");
		}	
	}
	
	/**
	 * The display method that displays employees in a sorted order by converting
	 * the grademap into an ArrayList and calling Collections.sort
	 * @param gm
	 */
	public static void display(Map<Employee, Integer> gm)
	{
		ArrayList<Employee> emp = new ArrayList<Employee>(gm.keySet());
		Collections.sort(emp);
		
		if(emp.isEmpty())
		{
			System.out.println("There are no employees in the map!\n");
		}
		else
		{
			for(Employee e: emp) //advanced for loop
			{
				System.out.println(e.toString() + "Grade: " + gm.get(e) + "\n");
			}
		}
	}
}
