import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OvertimePayTest {

    @DisplayName("calculatePay: 35 hours at $15.00, no overtime -> 525.0")
    @Test
    void calculatePay_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertEquals(525.0, emp.calculatePay(), 0.01, "15.00 * 35 - under 40 hours there is no overtime");
    }

    @DisplayName("calculatePay: 45 hours at $20.00 -> 950.0 (800 regular + 150 overtime)")
    @Test
    void calculatePay_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertEquals(950.0, emp.calculatePay(), 0.01,
                "(20 * 40) + (20 * 1.5 * 5) - only the 5 hours past 40 earn time-and-a-half");
    }

    @DisplayName("calculatePay: exactly 40 hours at $18.50 -> 740.0 (40 is NOT overtime)")
    @Test
    void calculatePay_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        assertEquals(740.0, emp.calculatePay(), 0.01, "the boundary: 18.50 * 40, no overtime portion");
    }

    @DisplayName("calculatePay: 50 hours at $25.00 -> 1375.0 (1000 regular + 375 overtime)")
    @Test
    void calculatePay_Test04() {
        HourlyEmployee emp = new HourlyEmployee("Diana", 104, 25.00, 50);
        assertEquals(1375.0, emp.calculatePay(), 0.01, "(25 * 40) + (25 * 1.5 * 10)");
    }

    @DisplayName("calculatePay: 20 hours at $12.00 -> 240.0")
    @Test
    void calculatePay_Test05() {
        HourlyEmployee emp = new HourlyEmployee("Eve", 105, 12.00, 20);
        assertEquals(240.0, emp.calculatePay(), 0.01, "12.00 * 20");
    }

    @DisplayName("calculatePay: 41 hours at $20.00 -> 830.0 (one hour of overtime = 30.0)")
    @Test
    void calculatePay_Test06() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 41);
        assertEquals(830.0, emp.calculatePay(), 0.01, "(20 * 40) + (20 * 1.5 * 1)");
    }

    @DisplayName("calculatePay: 0 hours -> 0.0")
    @Test
    void calculatePay_Test07() {
        HourlyEmployee emp = new HourlyEmployee("Zed", 106, 30.00, 0);
        assertEquals(0.0, emp.calculatePay(), 0.01, "no hours, no pay - and no negative overtime");
    }

    @DisplayName("calculatePay through an Employee reference: Employee e = new HourlyEmployee(\"Bob\", 102, 20.00, 45); e.calculatePay() -> 950.0, not the 0.0 base salary")
    @Test
    void calculatePay_Test08() {
        Employee e = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertEquals(950.0, e.calculatePay(), 0.01,
                "Employee.calculatePay() would return the base salary 0.0 - the override must run");
    }
}
