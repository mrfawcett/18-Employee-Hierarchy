/** READ FIRST
 * The Manager class is a subclass of Employee that represents
 * management-level employees who receive a bonus on top of their base
 * salary.
 *
 * A Manager has a department they manage and a bonus percentage written as
 * a decimal (0.15 means 15%).
 *
 * calculatePay() returns base salary plus the bonus:
 *   pay = baseSalary + baseSalary * bonusPercent
 *
 * EXAMPLE:
 *   Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *   mgr.calculatePay()  returns 92000.0
 *     Calculation: 80000.0 + (80000.0 * 0.15) = 80000.0 + 12000.0 = 92000.0
 *
 * getEmployeeInfo() adds the department to Employee's text:
 *   mgr.getEmployeeInfo()  returns "Carol (ID: 201) - Manager of Sales"
 *
 * canSupervise(Employee emp) decides whether this Manager may supervise emp.
 * A Manager can supervise any Employee who is NOT a Manager or an Executive.
 * (Executive extends Manager, so an Executive IS a Manager - one instanceof
 * check covers both.)
 *
 * EXAMPLES:
 *   HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
 *   Manager mgr1 = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
 *   Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
 *
 *   mgr1.canSupervise(emp1)  returns true  (can supervise hourly employees)
 *   mgr1.canSupervise(mgr2)  returns false (cannot supervise other managers)
 *
 * Information about name, ID, and base salary must be maintained in the
 * Employee class. Information about department and bonus percentage must
 * be maintained in the Manager class.
 *
 * The method headers are written for you so the tests compile. The bodies
 * and the fields are yours.
 */
public class Manager extends Employee {

    // DECLARE YOUR INSTANCE VARIABLES HERE
    // You need a private String for the department and a private double
    // for the bonus percentage.


    /** COMPLETE THIS CONSTRUCTOR
     * Precondition: bonusPercent >= 0
     * Creates a Manager. The super(...) call that hands name, ID, and salary
     * to Employee is already written. Store the two values that belong to
     * THIS class.
     * Example: new Manager("Carol", 201, 80000.0, "Sales", 0.15)
     */
    public Manager(String empName, int empID, double salary, String dept, double bonusPercent) {
        super(empName, empID, salary);
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Returns the department this manager oversees.
     * Example: mgr.getDepartment() -> "Sales"
     */
    public String getDepartment() {
        // Insert your code below

        return null;
    }

    /** COMPLETE THIS METHOD
     * Returns the bonus percentage as a decimal.
     * Example: mgr.getBonusPercent() -> 0.15
     */
    public double getBonusPercent() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Employee.calculatePay().
     * Returns baseSalary + baseSalary * bonusPercent.
     * Example: ("Carol", 201, 80000.0, "Sales", 0.15) -> 92000.0
     * Hint: baseSalary is private in Employee - use getBaseSalary().
     */
    public double calculatePay() {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Overrides Employee.getEmployeeInfo().
     * Returns "name (ID: employeeID) - Manager of department"
     * Example: mgr.getEmployeeInfo() -> "Carol (ID: 201) - Manager of Sales"
     * Hint: super.getEmployeeInfo() gives you "Carol (ID: 201)". Add to it.
     */
    public String getEmployeeInfo() {
        // Insert your code below

        return "";
    }

    /** COMPLETE THIS METHOD
     * Precondition: emp is not null
     * Returns true if emp is NOT a Manager (and therefore also not an
     * Executive); false otherwise.
     * Example: mgr1.canSupervise(new HourlyEmployee(...)) -> true
     *          mgr1.canSupervise(new Manager(...))        -> false
     *          mgr1.canSupervise(new Executive(...))      -> false
     * Hint: the instanceof operator. Remember that emp may be declared as an
     *       Employee but actually BE a Manager or Executive - instanceof looks
     *       at the object, not the variable.
     */
    public boolean canSupervise(Employee emp) {
        // Insert your code below

        return false;
    }
}
