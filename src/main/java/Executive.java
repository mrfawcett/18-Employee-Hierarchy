/* INSTRUCTIONS
 * The Executive class is a subclass of Manager that represents top-level
 * executives who receive stock options in addition to their salary and bonus.
 * 
 * An Executive has stock options (a dollar value) in addition to all the 
 * attributes of a Manager.
 * 
 * The calculatePay method returns the total compensation including base salary,
 * bonus, and the value of stock options.
 * 
 * EXAMPLE:
 *  Executive exec = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
 *  exec.calculatePay() returns 237500.0
 *    Calculation: 150000.0 + (150000.0 * 0.25) + 50000.0
 *               = 150000.0 + 37500.0 + 50000.0
 *               = 237500.0
 * 
 * The getEmployeeInfo method returns employee information indicating executive status.
 * EXAMPLE:
 *  exec.getEmployeeInfo() returns "Eve (ID: 301) - Executive of Operations"
 * 
 * The canSupervise method is overridden to allow Executives to supervise
 * anyone, including other Managers and Executives.
 * 
 * EXAMPLES:
 *  HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
 *  Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *  Executive exec1 = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
 *  Executive exec2 = new Executive("Frank", 302, 160000.0, "Finance", 0.30, 60000.0);
 * 
 *  exec1.canSupervise(emp1) returns true (can supervise hourly employees)
 *  exec1.canSupervise(mgr) returns true (can supervise managers)
 *  exec1.canSupervise(exec2) returns true (can supervise other executives)
 * 
 * Information about name, ID, and base salary must be maintained in the 
 * Employee class. Information about department and bonus percentage must be 
 * maintained in the Manager class. Information about stock options must be 
 * maintained in the Executive class.
 */

public class Executive extends Manager {
    // DECLARE INSTANCE VARIABLE(S) HERE
    // You need an instance variable for stock options value
    

    /* WRITE THE CONSTRUCTOR
     * Creates a new Executive with given name, ID, salary, department, bonus, and stock options
     * @param empName the name of the executive
     * @param empID the employee ID number
     * @param salary the base salary
     * @param dept the department the executive oversees
     * @param bonusPercent the bonus percentage (as a decimal)
     * @param stockOptions the value of stock options
     * 
     * HINT: Call the superclass (Manager) constructor to initialize name, ID, 
     * salary, department, and bonus, then initialize stock options
     */
    

    /* WRITE THE getStockOptions METHOD
     * Returns the value of stock options
     * @return the stock options value
     */
    

    /* WRITE THE calculatePay METHOD
     * Overrides the calculatePay method from Manager
     * Calculates total compensation as base salary + bonus + stock options
     * @return the total compensation
     * 
     * Formula: (baseSalary + bonus) + stockOptions
     * HINT: Use super.calculatePay() to get salary + bonus, then add stock options
     */
    

    /* WRITE THE getEmployeeInfo METHOD
     * Overrides the getEmployeeInfo method from Manager
     * Returns a string containing name, ID, and department with "Executive" title
     * @return a string in the format "name (ID: employeeID) - Executive of department"
     * 
     * HINT: You can use getName(), getEmployeeID(), and getDepartment()
     * Do NOT use super.getEmployeeInfo() because it says "Manager" instead of "Executive"
     */
    

    /* WRITE THE canSupervise METHOD
     * Overrides the canSupervise method from Manager
     * Executives can supervise ANY employee, including other managers and executives
     * @param emp the Employee to check
     * @return always returns true
     * 
     * This method is much simpler than the Manager version!
     */
    
}