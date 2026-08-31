/** READ FIRST
 * The HourlyEmployee class is a subclass of Employee that represents
 * employees who are paid by the hour rather than receiving a fixed salary.
 *
 * An HourlyEmployee has an hourly rate and tracks hours worked per week.
 *
 * calculatePay() returns the weekly pay from the hourly rate and the hours
 * worked. Hours beyond 40 are OVERTIME and are paid at 1.5 times the rate.
 *
 *   hours worked | pay
 *   -------------+------------------------------------------------
 *   h <= 40      | rate * h
 *   h > 40       | rate * 40  +  rate * 1.5 * (h - 40)
 *
 * EXAMPLES:
 *   HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 35);
 *   emp1.calculatePay()  returns 525.0     (15.00 * 35, no overtime)
 *
 *   HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
 *   emp2.calculatePay()  returns 950.0
 *     Calculation: (20.00 * 40) + (20.00 * 1.5 * 5) = 800 + 150 = 950
 *
 * getEmployeeInfo() adds the hourly rate to Employee's text:
 *   emp1.getEmployeeInfo()  returns "Alice (ID: 101) - Hourly: $15.0"
 *
 * Information about name, ID, and base salary must be maintained in the
 * Employee class. Information about hourly rate and hours worked must be
 * maintained in the HourlyEmployee class.
 *
 * Note: baseSalary is not used for hourly employees. Pass 0.0 as the
 * baseSalary to the Employee constructor (already done for you).
 *
 * The method headers are written for you so the tests compile. The bodies
 * and the fields are yours.
 */
public class HourlyEmployee extends Employee {

    // DECLARE YOUR INSTANCE VARIABLES HERE
    // You need two private doubles: hourly rate and hours worked per week.


    /** COMPLETE THIS CONSTRUCTOR
     * Precondition: hourlyRate >= 0 and hoursWorked >= 0
     * Creates an HourlyEmployee. The super(...) call that hands name and ID
     * to Employee (with 0.0 for base salary) is already written. Store the
     * two values that belong to THIS class.
     * Example: new HourlyEmployee("Alice", 101, 15.00, 35)
     */
    public HourlyEmployee(String empName, int empID, double hourlyRate, double hoursWorked) {
        super(empName, empID, 0.0);
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Returns the hourly rate.
     * Example: emp1.getHourlyRate() -> 15.0
     */
    public double getHourlyRate() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Returns the hours worked per week.
     * Example: emp1.getHoursWorked() -> 35.0
     */
    public double getHoursWorked() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Employee.calculatePay(). Returns the weekly pay:
     *   regular pay:  rate * hours, for the first 40 hours (or all of them if <= 40)
     *   overtime pay: rate * 1.5 * (hours - 40), only when hours > 40
     * Example: ("Bob", 102, 20.00, 45) -> 800.0 + 150.0 = 950.0
     *          ("Charlie", 103, 18.50, 40) -> 740.0 (exactly 40 is NOT overtime)
     * Hint: an if/else on hours > 40.
     */
    public double calculatePay() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Employee.getEmployeeInfo().
     * Returns "name (ID: employeeID) - Hourly: $hourlyRate"
     * Example: emp1.getEmployeeInfo() -> "Alice (ID: 101) - Hourly: $15.0"
     * Hint: super.getEmployeeInfo() gives you "Alice (ID: 101)". Add to it.
     *       Let Java print the double: 15.0, not 15 or 15.00.
     */
    public String getEmployeeInfo() {
        // Insert your code below

        return "";
    }
}
