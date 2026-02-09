# Employee Hierarchy Assignment

## Overview

In this assignment, you will implement an employee management system with multiple levels of inheritance. You will create three classes: `HourlyEmployee`, `Manager`, and `Executive`, all of which extend the provided `Employee` class.

## Background

The `Employee` class (provided) stores basic information about an employee:
- **Instance Variables:**
  - `name` (String) - The name of the employee
  - `employeeID` (int) - The employee ID number
  - `baseSalary` (double) - The base salary of the employee

- **Methods:**
  - `String getName()` - Returns the employee's name
  - `int getEmployeeID()` - Returns the employee ID
  - `double getBaseSalary()` - Returns the base salary
  - `String getEmployeeInfo()` - Returns a string in format `"name (ID: employeeID)"`
  - `double calculatePay()` - Returns the base salary

## Your Tasks

### Part 1: HourlyEmployee Class

Create the `HourlyEmployee` class that extends `Employee`. This class represents employees paid by the hour.

**Instance Variables:**
- `hourlyRate` (double) - The hourly pay rate
- `hoursWorked` (double) - Hours worked per week

**Methods to Implement:**
- Constructor: `HourlyEmployee(String empName, int empID, double hourlyRate, double hoursWorked)`
- `double getHourlyRate()` - Returns the hourly rate
- `double getHoursWorked()` - Returns hours worked
- `double calculatePay()` - Calculates weekly pay with overtime
  - Regular pay for up to 40 hours
  - Overtime (1.5x rate) for hours beyond 40
- `String getEmployeeInfo()` - Returns `"name (ID: id) - Hourly: $rate"`

**Examples:**
```java
HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 35);
emp1.calculatePay();  // returns 525.0 (15.00 * 35)

HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
emp2.calculatePay();  // returns 950.0
// Calculation: (20 * 40) + (20 * 1.5 * 5) = 800 + 150 = 950

emp1.getEmployeeInfo();  // returns "Alice (ID: 101) - Hourly: $15.0"
```

### Part 2: Manager Class

Create the `Manager` class that extends `Employee`. This class represents managers who receive bonuses.

**Instance Variables:**
- `department` (String) - The department managed
- `bonusPercent` (double) - Bonus as a decimal (0.15 = 15%)

**Methods to Implement:**
- Constructor: `Manager(String empName, int empID, double salary, String dept, double bonusPercent)`
- `String getDepartment()` - Returns the department
- `double getBonusPercent()` - Returns the bonus percentage
- `double calculatePay()` - Returns base salary + bonus
  - Formula: `baseSalary + (baseSalary * bonusPercent)`
- `String getEmployeeInfo()` - Returns `"name (ID: id) - Manager of department"`
- `boolean canSupervise(Employee emp)` - Returns true if emp is NOT a Manager or Executive

**Examples:**
```java
Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
mgr.calculatePay();  // returns 92000.0 (80000 + 12000)
mgr.getEmployeeInfo();  // returns "Carol (ID: 201) - Manager of Sales"

HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);

mgr.canSupervise(emp1);  // returns true
mgr.canSupervise(mgr2);  // returns false (can't supervise other managers)
```

### Part 3: Executive Class

Create the `Executive` class that extends `Manager`. This class represents top executives with stock options.

**Instance Variables:**
- `stockOptions` (double) - Value of stock options

**Methods to Implement:**
- Constructor: `Executive(String empName, int empID, double salary, String dept, double bonusPercent, double stockOptions)`
- `double getStockOptions()` - Returns stock options value
- `double calculatePay()` - Returns base salary + bonus + stock options
  - Use `super.calculatePay()` and add stock options
- `String getEmployeeInfo()` - Returns `"name (ID: id) - Executive of department"`
- `boolean canSupervise(Employee emp)` - Always returns true (executives can supervise anyone)

**Examples:**
```java
Executive exec = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
exec.calculatePay();  // returns 237500.0
// Calculation: 150000 + (150000 * 0.25) + 50000 = 237500

exec.getEmployeeInfo();  // returns "Eve (ID: 301) - Executive of Operations"

HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
Executive exec2 = new Executive("Frank", 302, 160000.0, "Finance", 0.30, 60000.0);

exec.canSupervise(emp1);   // returns true
exec.canSupervise(mgr);    // returns true
exec.canSupervise(exec2);  // returns true
```

## Inheritance Hierarchy

```
Employee (base class)
    ├── HourlyEmployee
    └── Manager
            └── Executive
```

## Testing

Your implementation will be tested using JUnit test files:
- `HourlyEmployeeTest.java`
- `ManagerTest.java`
- `ExecutiveTest.java`

Each test file covers constructors, getters, `calculatePay()`, `getEmployeeInfo()`, and `canSupervise()` methods.

## Important Notes

- Use `super()` to call parent class constructors
- Use `super.methodName()` to avoid code duplication when overriding methods
- For `HourlyEmployee`, pass 0.0 as baseSalary to the Employee constructor
- The `instanceof` operator will be helpful for the `canSupervise()` method in Manager
- Pay attention to which class each piece of data belongs to

## Submission

Complete all three classes:
1. `HourlyEmployee.java`
2. `Manager.java`
3. `Executive.java`

Make sure all test cases pass before submitting your work.