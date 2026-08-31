# Employee Hierarchy

**Unit 4 — Inheritance and Polymorphism** · Pairs with lectures 4.2.1 Casting & `instanceof` and 4.3 Hierarchy Design Lab

You are building a small payroll system with **three levels** of inheritance.
`Employee` (given) knows a name, an ID, and a base salary. You write
`HourlyEmployee` (paid by the hour, with overtime), `Manager` (salary plus a
bonus, and a rule about who they may supervise), and `Executive` — which
extends `Manager`, not `Employee`, so it inherits the bonus logic and adds
stock options on top. Every class overrides `calculatePay()` and
`getEmployeeInfo()`, and `canSupervise` is where `instanceof` earns its keep:
a `Manager` may not supervise another `Manager`, and because an `Executive`
*is a* `Manager`, one check rules out both.

This is the `Employee` option from the 4.3 Hierarchy Design Lab, spec for
spec, so if you did that lab on paper you already have the design.

```
Employee                         name, employeeID, baseSalary
    ├── HourlyEmployee           + hourlyRate, hoursWorked
    └── Manager                  + department, bonusPercent, canSupervise
            └── Executive        + stockOptions
```

---

## What you are given

| File | Status | Purpose |
|---|---|---|
| `src/main/java/HourlyEmployee.java` | **you complete this** | fields, constructor, 2 getters, `calculatePay`, `getEmployeeInfo` |
| `src/main/java/Manager.java` | **you complete this** | fields, constructor, 2 getters, `calculatePay`, `getEmployeeInfo`, `canSupervise` |
| `src/main/java/Executive.java` | **you complete this** | field, constructor, `getStockOptions`, `calculatePay`, `getEmployeeInfo`, `canSupervise` |
| `src/main/java/Employee.java` | provided | the root class — **do not modify** |
| `src/test/java/*Test.java` | provided | the autograder's tests — read them |

### The `Employee` class

```
Employee
  private String name
  private int employeeID
  private double baseSalary
  Employee(String empName, int empID, double salary)
  String getName()
  int getEmployeeID()
  double getBaseSalary()
  String getEmployeeInfo()     returns "name (ID: employeeID)", e.g. "Alice (ID: 101)"
  double calculatePay()        returns the base salary
```

All three fields are private. Your subclasses reach them only through the
constructor (`super(...)`) and the accessors.

In every file the method headers are written for you so the tests compile,
and each constructor already has its `super(...)` line. You add the fields
and the bodies.

---

## What to write

| Rubric line | Points | What it covers |
|---|---|---|
| `HourlyEmployee`: constructor, getters, `getEmployeeInfo` | 15 | fields stored, `"name (ID: id) - Hourly: $rate"` |
| `HourlyEmployee.calculatePay` | 15 | time-and-a-half past 40 hours |
| `Manager`: constructor, getters, `calculatePay`, `getEmployeeInfo` | 20 | salary + bonus, `"name (ID: id) - Manager of dept"` |
| `canSupervise` in `Manager` and `Executive` | 25 | `instanceof`, and the override that says yes to everyone |
| `Executive`: constructor, `getStockOptions`, `calculatePay`, `getEmployeeInfo` | 25 | `super.calculatePay()` + options, `"... - Executive of dept"` |

### Part 1: `HourlyEmployee extends Employee`

**Fields:** `hourlyRate` (double), `hoursWorked` (double — hours per week).

**Constructor:** `HourlyEmployee(String empName, int empID, double hourlyRate, double hoursWorked)`.
The `super(empName, empID, 0.0)` call is written for you — hourly employees
have no base salary, so `0.0` goes up to `Employee`. Store the rate and hours.

**Methods:**

- `double getHourlyRate()`, `double getHoursWorked()` — plain getters.
- `double calculatePay()` — weekly pay with overtime:

  | hours `h` | pay |
  |---|---|
  | `h <= 40` | `rate * h` |
  | `h > 40` | `rate * 40 + rate * 1.5 * (h - 40)` |

- `String getEmployeeInfo()` — `"name (ID: id) - Hourly: $rate"`. Use
  `super.getEmployeeInfo()` and append.

```java
HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 35);
emp1.calculatePay();       // 525.0            (15.00 * 35)
emp1.getEmployeeInfo();    // "Alice (ID: 101) - Hourly: $15.0"

HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
emp2.calculatePay();       // 950.0            (20 * 40) + (20 * 1.5 * 5) = 800 + 150
```

**Traps:** paying 1.5× for *all* hours once over 40 (Bob would get 1350);
subtracting 40 when hours are under 40 (Alice would get 487.5); treating
exactly 40 as overtime (it is not — `Charlie` at 18.50 × 40 is 740.0).
Java prints `15.00` as `15.0` and `18.50` as `18.5`; let it.

### Part 2: `Manager extends Employee`

**Fields:** `department` (String), `bonusPercent` (double, as a decimal —
`0.15` means 15%).

**Constructor:** `Manager(String empName, int empID, double salary, String dept, double bonusPercent)`.
`super(empName, empID, salary)` is written for you.

**Methods:**

- `String getDepartment()`, `double getBonusPercent()` — getters.
- `double calculatePay()` — `baseSalary + baseSalary * bonusPercent`. The
  salary is private in `Employee`; use `getBaseSalary()`.
- `String getEmployeeInfo()` — `"name (ID: id) - Manager of department"`,
  via `super.getEmployeeInfo()`.
- `boolean canSupervise(Employee emp)` — `true` if `emp` is **not** a
  `Manager` or `Executive`. Since `Executive extends Manager`,
  `emp instanceof Manager` is already `true` for an executive — one check
  covers both. `instanceof` looks at the **object**, so an `Executive` stored
  in an `Employee` variable is still caught.

```java
Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
mgr.calculatePay();        // 92000.0          (80000 + 12000)
mgr.getEmployeeInfo();     // "Carol (ID: 201) - Manager of Sales"

HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
mgr.canSupervise(emp1);    // true
mgr.canSupervise(mgr2);    // false            (cannot supervise other managers)
```

**Trap:** returning only the bonus (`baseSalary * bonusPercent`). The test
with a `0.0` bonus pays exactly the base salary, not `0.0`.

### Part 3: `Executive extends Manager`

**Field:** `stockOptions` (double — a dollar value).

**Constructor:** `Executive(String empName, int empID, double salary, String dept, double bonusPercent, double stockOptions)`.
`super(empName, empID, salary, dept, bonusPercent)` is written for you — note
it calls `Manager`'s constructor, which calls `Employee`'s.

**Methods:**

- `double getStockOptions()` — getter.
- `double calculatePay()` — base salary + bonus + stock options. **Use
  `super.calculatePay()`** for the first two terms and add the options. Do not
  retype the bonus formula.
- `String getEmployeeInfo()` — `"name (ID: id) - Executive of department"`.
  Here `super.getEmployeeInfo()` would say *Manager*, so build the string from
  `getName()`, `getEmployeeID()`, and `getDepartment()` instead.
- `boolean canSupervise(Employee emp)` — always `true`. Executives supervise
  anyone, including other managers and executives.

```java
Executive exec = new Executive("Eve", 301, 150000.0, "Operations", 0.25, 50000.0);
exec.calculatePay();       // 237500.0         150000 + (150000 * 0.25) + 50000
exec.getEmployeeInfo();    // "Eve (ID: 301) - Executive of Operations"

Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
Executive exec2 = new Executive("Frank", 302, 160000.0, "Finance", 0.30, 60000.0);
exec.canSupervise(emp1);   // true
exec.canSupervise(mgr);    // true
exec.canSupervise(exec2);  // true
```

---

## Examples

```java
Employee e = new HourlyEmployee("Bob", 102, 20.00, 45);
e.calculatePay();          // 950.0  -- HourlyEmployee's version, not Employee's 0.0
e.getEmployeeInfo();       // "Bob (ID: 102) - Hourly: $20.0"

Manager m = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
m.canSupervise(new Manager("Carol", 201, 80000.0, "Sales", 0.15));
                           // true  -- the object is an Executive; its override runs

Manager carol = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
Employee hidden = new Manager("Dave", 202, 85000.0, "IT", 0.20);
carol.canSupervise(hidden); // false -- instanceof sees the Manager inside the Employee variable

new Manager("Gus", 205, 90000.0, "Facilities", 0.0).calculatePay();    // 90000.0
new Executive("Frank", 301, 150000.0, "Operations", 0.25, 0.0).calculatePay();  // 187500.0
```

---

## Running the tests

`mvn test` runs everything; `mvn test -Dtest=CanSuperviseTest` runs one rubric line.

| Test class | Rubric line | Points |
|---|---|---|
| `HourlyEmployeeTest` | HourlyEmployee: constructor, getters, getEmployeeInfo | 15 |
| `OvertimePayTest` | HourlyEmployee.calculatePay with overtime past 40 hours | 15 |
| `ManagerTest` | Manager: constructor, getters, calculatePay, getEmployeeInfo | 20 |
| `CanSuperviseTest` | canSupervise with instanceof (Manager) and its override (Executive) | 25 |
| `ExecutiveTest` | Executive: constructor, getStockOptions, calculatePay via super, getEmployeeInfo | 25 |

The autograder awards a rubric line only when every test in that class passes.

## Suggested order

1. `HourlyEmployee` — fields, constructor, the two getters. Run
   `HourlyEmployeeTest`; the `getEmployeeInfo` tests will still fail.
2. `HourlyEmployee.getEmployeeInfo()`, then `calculatePay()`. Check 35, 40,
   and 45 hours by hand before you run `OvertimePayTest`.
3. `Manager` — everything except `canSupervise`. Run `ManagerTest`.
4. `Executive` — the constructor must compile before `CanSuperviseTest` can
   even build an executive. Do the field, constructor, `getStockOptions`,
   `calculatePay`, `getEmployeeInfo`. Run `ExecutiveTest`.
5. `canSupervise` in `Manager` (one `instanceof`), then in `Executive`
   (one `return`). Run `CanSuperviseTest`. Read the test that stores a
   `Manager` in an `Employee` variable and explain why it still returns
   `false`.

## Rules of the road

- AP Java subset only: `double`, `String`, `if`, `instanceof`, `super`,
  string concatenation. No `String.format`, `Math.round`, or `getClass()`
  comparisons — `instanceof` is the tool.
- Do not change method headers or provided code. `Employee.java` stays
  exactly as it is.
- Keep each piece of data in the class it belongs to: name/ID/salary in
  `Employee`, rate/hours in `HourlyEmployee`, department/bonus in `Manager`,
  stock options in `Executive`. No duplicate fields.
- Do not touch `src/test`, `pom.xml`, `grading.json`, or `.github`. The
  autograder checks that they are byte-identical to the template before it
  runs a single test; if they differ it stops and awards nothing, and the
  change shows up in the roster.
