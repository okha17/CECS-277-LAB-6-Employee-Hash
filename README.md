# CECS-277-LAB-6-Employee-Hash
CECS 277
LAB ASSIGNMENT 6
Assigned date: 10/14
Due date: 10/21
25 points


Write a program that keeps a map in which the keys of the map are objects of class Employee. An employee should have a first name, a last name, and a unique integer employee identification. For the work performance (5, 4, 3, 2, and 1) changes and removals, lookup should be by employee identification. Prompt the user of the program to add or remove employees, to modify the performance, or to print all the performances including employee names. The printout should be sorted by last name. If two employees have the same last name, then use the first name as a tie breaker. If the first names are also identical, then use the integer employee identification. Supply compatible hashCode and equals methods to the Employee class.
Implementing the following methods:

    public static printMenuAndGetChoice()
    /**
    Adds a employee based on user input.  Prints an error if a employee
    is added that already exists in the map.
    @param GradeMap the map to associate employee object with a performance
    @param employeeMap the map to associate employee id with an employee.
    */
    /**
    Removes a employee from the map based on user input
    @param GradeMap the map to associate employee object with a grade.
    @param employeeMap the map to associate employee id with an employee. */
    /**
    Modifies an entry based on user input.  Prints an error if an invalid employee is modified.
    @param GradeMap the map to associate employee object with a grade.
    @param employeeMap the map to associate employee id with an employee
    */
       /**
    Prints the employees and performances
    @param GradeMap the map to print
    */

Hint:

    Use two maps.
    Calculates a hashcode by combining the hashcodes of the instance variables.
    @return a hashcode dependant on the instance variables
    */
    public int hashCode()
    {
    final int HASH_MULTIPLIER = 29;
    int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
    h = HASH_MULTIPLIER * h + ((Integer)id).hashCode();
    return h;
    }
