/* INSTRUCTIONS
 * The HourlyEmployee class is a subclass of Employee that represents employees
 * who are paid by the hour rather than receiving a fixed salary.
 * 
 * An HourlyEmployee has an hourly rate and tracks hours worked per week.
 * 
 * The calculatePay method returns the weekly pay based on hourly rate and 
 * hours worked. If the employee works more than 40 hours, they receive 
 * overtime pay at 1.5 times their hourly rate for hours beyond 40.
 * 
 * EXAMPLES:
 *  HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 35);
 *  emp1.calculatePay() returns 525.0 (15.00 * 35, no overtime)
 * 
 *  HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
 *  emp2.calculatePay() returns 950.0
 *    Calculation: (20.00 * 40) + (20.00 * 1.5 * 5) = 800 + 150 = 950
 * 
 * The getEmployeeInfo method returns employee information including hourly rate.
 * EXAMPLE:
 *  emp1.getEmployeeInfo() returns "Alice (ID: 101) - Hourly: $15.0"
 * 
 * Information about name, ID, and base salary must be maintained in the 
 * Employee class. Information about hourly rate and hours worked must be 
 * maintained in the HourlyEmployee class.
 * 
 * Note: The baseSalary in Employee is not used for HourlyEmployee calculations.
 * You may pass 0.0 as the baseSalary when calling the superclass constructor.
 */

public class HourlyEmployee extends Employee {
    // DECLARE INSTANCE VARIABLE(S) HERE
    // You need instance variables for hourly rate and hours worked per week
    

    /* WRITE THE CONSTRUCTOR
     * Creates a new HourlyEmployee with given name, ID, hourly rate, and hours worked
     * @param empName the name of the employee
     * @param empID the employee ID number
     * @param hourlyRate the hourly pay rate
     * @param hoursWorked the number of hours worked per week
     * 
     * HINT: Call the superclass constructor with 0.0 for baseSalary since
     * hourly employees don't use a fixed salary
     */
    

    /* WRITE THE getHourlyRate METHOD
     * Returns the hourly rate of this employee
     * @return the hourly rate
     */
    

    /* WRITE THE getHoursWorked METHOD
     * Returns the hours worked per week
     * @return the hours worked per week
     */
    

    /* WRITE THE calculatePay METHOD
     * Overrides the calculatePay method from Employee
     * Calculates weekly pay including overtime if applicable
     * @return the total weekly pay
     * 
     * Rules:
     * - Regular pay: hourly rate * hours (up to 40 hours)
     * - Overtime pay: hourly rate * 1.5 * (hours - 40) for hours over 40
     * - Total pay = regular pay + overtime pay
     */
    

    /* WRITE THE getEmployeeInfo METHOD
     * Overrides the getEmployeeInfo method from Employee
     * Returns a string containing name, ID, and hourly rate
     * @return a string in the format "name (ID: employeeID) - Hourly: $hourlyRate"
     * 
     * HINT: Use super.getEmployeeInfo() and add the hourly rate information
     */
    
}