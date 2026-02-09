public class Employee {
    /** The name of the employee */
    private String name;
    
    /** The employee ID number */
    private int employeeID;
    
    /** The base salary of the employee */
    private double baseSalary;
    
    /** Creates a new Employee with given name, ID, and base salary
     * @param empName the name of the employee
     * @param empID the employee ID number
     * @param salary the base salary of the employee
     */
    public Employee(String empName, int empID, double salary) {
        name = empName;
        employeeID = empID;
        baseSalary = salary;
    }
    
    /** Returns the name of the employee
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }
    
    /** Returns the employee ID number
     * @return the employee ID number
     */
    public int getEmployeeID() {
        return employeeID;
    }
    
    /** Returns the base salary of the employee
     * @return the base salary of the employee
     */
    public double getBaseSalary() {
        return baseSalary;
    }
    
    /** Returns the employee information as a string
     * @return a string in the format "name (ID: employeeID)"
     */
    public String getEmployeeInfo() {
        return name + " (ID: " + employeeID + ")";
    }
    
    /** Calculates and returns the total pay for the employee
     * @return the base salary
     */
    public double calculatePay() {
        return baseSalary;
    }
}