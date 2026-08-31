import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyEmployeeTest {

    @DisplayName("constructor: new HourlyEmployee(\"Alice\", 101, 15.00, 35) passes name and ID up to Employee")
    @Test
    void constructor_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals("Alice", emp.getName(), "name should reach Employee through super(...)");
        assertEquals(101, emp.getEmployeeID(), "ID should reach Employee through super(...)");
    }

    @DisplayName("constructor: an hourly employee's base salary is 0.0")
    @Test
    void constructor_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals(0.0, emp.getBaseSalary(), 0.001, "pass 0.0 as the base salary - hourly employees have none");
    }

    @DisplayName("constructor: stores the hourly rate - getHourlyRate() is 15.0")
    @Test
    void constructor_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals(15.00, emp.getHourlyRate(), 0.01, "the rate belongs in HourlyEmployee's own field");
    }

    @DisplayName("constructor: stores the hours worked - getHoursWorked() is 35.0")
    @Test
    void constructor_Test04() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals(35, emp.getHoursWorked(), 0.01, "the hours belong in HourlyEmployee's own field");
    }

    @DisplayName("constructor: two employees keep their own rate and hours (Bob 20.00/45, Charlie 18.50/40)")
    @Test
    void constructor_Test05() {
        HourlyEmployee emp1 = new HourlyEmployee("Bob", 102, 20.00, 45);
        HourlyEmployee emp2 = new HourlyEmployee("Charlie", 103, 18.50, 40);
        assertEquals(20.00, emp1.getHourlyRate(), 0.01, "Bob's rate");
        assertEquals(45, emp1.getHoursWorked(), 0.01, "Bob's hours");
        assertEquals(18.50, emp2.getHourlyRate(), 0.01, "Charlie's rate");
        assertEquals(40, emp2.getHoursWorked(), 0.01, "Charlie's hours - fields must not be static");
    }

    @DisplayName("getHourlyRate: Bob -> 20.0")
    @Test
    void getHourlyRate_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertEquals(20.00, emp.getHourlyRate(), 0.01);
    }

    @DisplayName("getHourlyRate: Charlie -> 18.5")
    @Test
    void getHourlyRate_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        assertEquals(18.50, emp.getHourlyRate(), 0.01);
    }

    @DisplayName("getHoursWorked: Bob -> 45.0")
    @Test
    void getHoursWorked_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertEquals(45, emp.getHoursWorked(), 0.01);
    }

    @DisplayName("getEmployeeInfo: Alice -> \"Alice (ID: 101) - Hourly: $15.0\"")
    @Test
    void getEmployeeInfo_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals("Alice (ID: 101) - Hourly: $15.0", emp.getEmployeeInfo(),
                "use super.getEmployeeInfo() then add \" - Hourly: $\" and the rate");
    }

    @DisplayName("getEmployeeInfo: Charlie -> \"Charlie (ID: 103) - Hourly: $18.5\" (Java prints 18.50 as 18.5)")
    @Test
    void getEmployeeInfo_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        assertEquals("Charlie (ID: 103) - Hourly: $18.5", emp.getEmployeeInfo(),
                "let Java format the double - do not pad or round it");
    }

    @DisplayName("getEmployeeInfo through an Employee reference: Employee e = new HourlyEmployee(\"Bob\", ...) -> \"Bob (ID: 102) - Hourly: $20.0\"")
    @Test
    void getEmployeeInfo_Test03() {
        Employee e = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertEquals("Bob (ID: 102) - Hourly: $20.0", e.getEmployeeInfo(),
                "the object is an HourlyEmployee, so its override runs even through an Employee variable");
    }
}
