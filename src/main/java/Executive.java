/** READ FIRST
 * The Executive class is a subclass of Manager that represents top-level
 * executives who receive stock options in addition to salary and bonus.
 *
 * An Executive has stock options (a dollar value) plus everything a
 * Manager has: name, ID, base salary, department, bonus percentage.
 *
 * calculatePay() returns base salary + bonus + stock options.
 *
 * EXAMPLE:
 *   Executive exec = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
 *   exec.calculatePay()  returns 237500.0
 *     Calculation: 150000.0 + (150000.0 * 0.25) + 50000.0
 *                = 150000.0 + 37500.0 + 50000.0
 *                = 237500.0
 *
 * getEmployeeInfo() says Executive instead of Manager:
 *   exec.getEmployeeInfo()  returns "Eve (ID: 301) - Executive of Operations"
 *
 * canSupervise(Employee emp) is overridden so an Executive can supervise
 * ANYONE, including other Managers and Executives.
 *
 * EXAMPLES:
 *   HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
 *   Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *   Executive exec1 = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
 *   Executive exec2 = new Executive("Frank", 302, 160000.0, "Finance", 0.30, 60000.0);
 *
 *   exec1.canSupervise(emp1)   returns true (can supervise hourly employees)
 *   exec1.canSupervise(mgr)    returns true (can supervise managers)
 *   exec1.canSupervise(exec2)  returns true (can supervise other executives)
 *
 * Information about name, ID, and base salary must be maintained in the
 * Employee class. Information about department and bonus percentage must
 * be maintained in the Manager class. Information about stock options must
 * be maintained in the Executive class.
 *
 * The method headers are written for you so the tests compile. The bodies
 * and the field are yours.
 */
public class Executive extends Manager {

    // DECLARE YOUR INSTANCE VARIABLE HERE
    // You need one private double for the stock options value.


    /** COMPLETE THIS CONSTRUCTOR
     * Precondition: stockOptions >= 0
     * Creates an Executive. The super(...) call that hands name, ID, salary,
     * department, and bonus to Manager is already written. Store the one
     * value that belongs to THIS class.
     * Example: new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0)
     */
    public Executive(String empName, int empID, double salary, String dept, double bonusPercent, double stockOptions) {
        super(empName, empID, salary, dept, bonusPercent);
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Returns the value of the stock options.
     * Example: exec.getStockOptions() -> 50000.0
     */
    public double getStockOptions() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Manager.calculatePay().
     * Returns (base salary + bonus) + stock options.
     * Example: ("Eve", 301, 150000.0, "Operations", 0.25, 50000.0) -> 237500.0
     * Hint: super.calculatePay() already computes salary + bonus. Do not
     *       retype the bonus formula - add stock options to what Manager gives you.
     */
    public double calculatePay() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Manager.getEmployeeInfo().
     * Returns "name (ID: employeeID) - Executive of department"
     * Example: exec.getEmployeeInfo() -> "Eve (ID: 301) - Executive of Operations"
     * Hint: super.getEmployeeInfo() would say "Manager of ...", which is wrong
     *       here. Build the string from getName(), getEmployeeID(), and
     *       getDepartment() instead.
     */
    public String getEmployeeInfo() {
        // Insert your code below

        return "";
    }

    /** COMPLETE THIS METHOD
     * Overrides Manager.canSupervise(). An Executive can supervise ANY
     * employee, including other Managers and Executives.
     * Example: exec1.canSupervise(mgr) -> true ; exec1.canSupervise(exec2) -> true
     * Hint: this one is much simpler than the Manager version.
     */
    public boolean canSupervise(Employee emp) {
        // Insert your code below

        return false;
    }
}
