/* INSTRUCTIONS
 * The Manager class is a subclass of Employee that represents management-level
 * employees who receive a bonus in addition to their base salary.
 * 
 * A Manager has a department they manage and a bonus percentage (as a decimal).
 * 
 * The calculatePay method returns the total pay including the base salary 
 * plus a bonus calculated as a percentage of the base salary.
 * 
 * EXAMPLE:
 *  Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *  mgr.calculatePay() returns 92000.0
 *    Calculation: 80000.0 + (80000.0 * 0.15) = 80000.0 + 12000.0 = 92000.0
 * 
 * The getEmployeeInfo method returns employee information including department.
 * EXAMPLE:
 *  mgr.getEmployeeInfo() returns "Carol (ID: 201) - Manager of Sales"
 * 
 * The canSupervise method determines if this Manager can supervise another
 * employee. A Manager can supervise any Employee who is NOT a Manager or Executive.
 * 
 * EXAMPLES:
 *  HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
 *  Manager mgr1 = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *  Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
 * 
 *  mgr1.canSupervise(emp1) returns true (can supervise hourly employees)
 *  mgr1.canSupervise(mgr2) returns false (cannot supervise other managers)
 * 
 * Information about name, ID, and base salary must be maintained in the 
 * Employee class. Information about department and bonus percentage must be 
 * maintained in the Manager class.
 */

public class Manager extends Employee {
    // DECLARE INSTANCE VARIABLE(S) HERE
    // You need instance variables for department and bonus percentage
    

    /* WRITE THE CONSTRUCTOR
     * Creates a new Manager with given name, ID, salary, department, and bonus percentage
     * @param empName the name of the manager
     * @param empID the employee ID number
     * @param salary the base salary
     * @param dept the department the manager oversees
     * @param bonusPercent the bonus percentage (as a decimal, e.g., 0.15 for 15%)
     * 
     * HINT: Call the superclass constructor to initialize name, ID, and salary,
     * then initialize department and bonus percentage
     */
    

    /* WRITE THE getDepartment METHOD
     * Returns the department this manager oversees
     * @return the department name
     */
    

    /* WRITE THE getBonusPercent METHOD
     * Returns the bonus percentage
     * @return the bonus percentage as a decimal
     */
    

    /* WRITE THE calculatePay METHOD
     * Overrides the calculatePay method from Employee
     * Calculates total pay as base salary plus bonus
     * @return the total pay (base salary + bonus)
     * 
     * Formula: baseSalary + (baseSalary * bonusPercent)
     * HINT: Use getBaseSalary() to access the base salary
     */
    

    /* WRITE THE getEmployeeInfo METHOD
     * Overrides the getEmployeeInfo method from Employee
     * Returns a string containing name, ID, and department
     * @return a string in the format "name (ID: employeeID) - Manager of department"
     * 
     * HINT: Use super.getEmployeeInfo() and add the department information
     */
    

    /* WRITE THE canSupervise METHOD
     * Determines if this Manager can supervise another employee
     * @param emp the Employee to check
     * @return true if emp is NOT an instance of Manager or Executive;
     *         false otherwise
     * 
     * HINT: Use the instanceof operator to check the type of emp
     * A Manager can supervise HourlyEmployee and regular Employee objects,
     * but NOT other Managers or Executives
     */
    
}