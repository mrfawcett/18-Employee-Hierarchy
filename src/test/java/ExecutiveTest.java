import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExecutiveTest {

    @DisplayName("constructor: new Executive(\"Frank\", 301, 150000.0, \"Operations\", 0.25, 50000.0) passes name, ID, salary up to Employee")
    @Test
    void constructor_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals("Frank", exec.getName(), "name should reach Employee through the chain of super(...) calls");
        assertEquals(301, exec.getEmployeeID(), "ID");
        assertEquals(150000.0, exec.getBaseSalary(), 0.01, "salary");
    }

    @DisplayName("constructor: passes department and bonus up to Manager - \"Operations\" and 0.25")
    @Test
    void constructor_Test02() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals("Operations", exec.getDepartment(), "department lives in Manager - reach it through super(...)");
        assertEquals(0.25, exec.getBonusPercent(), 0.001, "bonus percent lives in Manager");
    }

    @DisplayName("constructor: stores the stock options - getStockOptions() is 50000.0")
    @Test
    void constructor_Test03() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals(50000.0, exec.getStockOptions(), 0.01, "stock options belong in Executive's own field");
    }

    @DisplayName("constructor: two executives keep separate stock options (Grace 60000.0, Henry 70000.0)")
    @Test
    void constructor_Test04() {
        Executive exec1 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        Executive exec2 = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        assertEquals(60000.0, exec1.getStockOptions(), 0.01, "Grace");
        assertEquals(70000.0, exec2.getStockOptions(), 0.01, "Henry - the field must not be static");
        assertEquals("Finance", exec1.getDepartment(), "Grace's department");
        assertEquals("Technology", exec2.getDepartment(), "Henry's department");
    }

    @DisplayName("getStockOptions: Grace -> 60000.0")
    @Test
    void getStockOptions_Test01() {
        Executive exec = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        assertEquals(60000.0, exec.getStockOptions(), 0.01);
    }

    @DisplayName("calculatePay: Frank 150000.0 at 25% + 50000.0 options -> 237500.0")
    @Test
    void calculatePay_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals(237500.0, exec.calculatePay(), 0.01, "150000 + 37500 + 50000 - use super.calculatePay() for the first two");
    }

    @DisplayName("calculatePay: Grace 160000.0 at 30% + 60000.0 -> 268000.0")
    @Test
    void calculatePay_Test02() {
        Executive exec = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        assertEquals(268000.0, exec.calculatePay(), 0.01, "160000 + 48000 + 60000");
    }

    @DisplayName("calculatePay: Henry 170000.0 at 35% + 70000.0 -> 299500.0")
    @Test
    void calculatePay_Test03() {
        Executive exec = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        assertEquals(299500.0, exec.calculatePay(), 0.01, "170000 + 59500 + 70000");
    }

    @DisplayName("calculatePay: Irene 200000.0 at 20% + 80000.0 -> 320000.0")
    @Test
    void calculatePay_Test04() {
        Executive exec = new Executive("Irene", 304, 200000.0, "Legal", 0.20, 80000.0);
        assertEquals(320000.0, exec.calculatePay(), 0.01, "200000 + 40000 + 80000");
    }

    @DisplayName("calculatePay: 0.0 stock options -> the same as a Manager's pay (150000.0 at 25% -> 187500.0)")
    @Test
    void calculatePay_Test05() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 0.0);
        assertEquals(187500.0, exec.calculatePay(), 0.01, "150000 + 37500 + 0 - the bonus must still be included");
    }

    @DisplayName("getEmployeeInfo: Frank -> \"Frank (ID: 301) - Executive of Operations\"")
    @Test
    void getEmployeeInfo_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals("Frank (ID: 301) - Executive of Operations", exec.getEmployeeInfo(),
                "says Executive, not Manager - build it from getName(), getEmployeeID(), getDepartment()");
    }

    @DisplayName("getEmployeeInfo through an Employee reference: Employee e = new Executive(\"Grace\", 302, ..., \"Finance\", ...) -> \"Grace (ID: 302) - Executive of Finance\"")
    @Test
    void getEmployeeInfo_Test02() {
        Employee e = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        assertEquals("Grace (ID: 302) - Executive of Finance", e.getEmployeeInfo(),
                "the object is an Executive, so its override runs - not Manager's, not Employee's");
        Executive henry = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        assertEquals("Henry (ID: 303) - Executive of Technology", henry.getEmployeeInfo());
    }
}
