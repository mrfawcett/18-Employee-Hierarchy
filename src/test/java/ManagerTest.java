import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @DisplayName("constructor: new Manager(\"Carol\", 201, 80000.0, \"Sales\", 0.15) passes name, ID, and salary up to Employee")
    @Test
    void constructor_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals("Carol", mgr.getName(), "name should reach Employee through super(...)");
        assertEquals(201, mgr.getEmployeeID(), "ID should reach Employee through super(...)");
        assertEquals(80000.0, mgr.getBaseSalary(), 0.01, "salary should reach Employee through super(...)");
    }

    @DisplayName("constructor: stores the department - getDepartment() is \"Sales\"")
    @Test
    void constructor_Test02() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals("Sales", mgr.getDepartment(), "the department belongs in Manager's own field");
    }

    @DisplayName("constructor: stores the bonus percent - getBonusPercent() is 0.15")
    @Test
    void constructor_Test03() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals(0.15, mgr.getBonusPercent(), 0.001, "the bonus percent belongs in Manager's own field");
    }

    @DisplayName("getDepartment: Dave -> \"IT\"; two managers keep separate departments")
    @Test
    void getDepartment_Test01() {
        Manager mgr1 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        Manager mgr2 = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        assertEquals("IT", mgr1.getDepartment());
        assertEquals("Marketing", mgr2.getDepartment(), "creating Eve must not change Dave - fields must not be static");
        assertEquals("IT", mgr1.getDepartment());
    }

    @DisplayName("getBonusPercent: Dave -> 0.2, Eve -> 0.1")
    @Test
    void getBonusPercent_Test01() {
        Manager mgr1 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        Manager mgr2 = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        assertEquals(0.20, mgr1.getBonusPercent(), 0.001);
        assertEquals(0.10, mgr2.getBonusPercent(), 0.001);
    }

    @DisplayName("calculatePay: Carol 80000.0 at 15% -> 92000.0")
    @Test
    void calculatePay_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals(92000.0, mgr.calculatePay(), 0.01, "80000 + 80000 * 0.15 - the bonus is ADDED to the salary");
    }

    @DisplayName("calculatePay: Dave 85000.0 at 20% -> 102000.0")
    @Test
    void calculatePay_Test02() {
        Manager mgr = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        assertEquals(102000.0, mgr.calculatePay(), 0.01, "85000 + 17000");
    }

    @DisplayName("calculatePay: Eve 90000.0 at 10% -> 99000.0")
    @Test
    void calculatePay_Test03() {
        Manager mgr = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        assertEquals(99000.0, mgr.calculatePay(), 0.01, "90000 + 9000");
    }

    @DisplayName("calculatePay: Frank 100000.0 at 25% -> 125000.0")
    @Test
    void calculatePay_Test04() {
        Manager mgr = new Manager("Frank", 204, 100000.0, "Finance", 0.25);
        assertEquals(125000.0, mgr.calculatePay(), 0.01, "100000 + 25000");
    }

    @DisplayName("calculatePay: a 0.0 bonus percent pays exactly the base salary (90000.0)")
    @Test
    void calculatePay_Test05() {
        Manager mgr = new Manager("Gus", 205, 90000.0, "Facilities", 0.0);
        assertEquals(90000.0, mgr.calculatePay(), 0.01, "90000 + 90000 * 0 - returning only the bonus gives 0.0 here");
    }

    @DisplayName("getEmployeeInfo: Carol -> \"Carol (ID: 201) - Manager of Sales\"")
    @Test
    void getEmployeeInfo_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals("Carol (ID: 201) - Manager of Sales", mgr.getEmployeeInfo(),
                "use super.getEmployeeInfo() then add \" - Manager of \" and the department");
    }

    @DisplayName("getEmployeeInfo through an Employee reference: Employee e = new Manager(\"Dave\", 202, ...) -> \"Dave (ID: 202) - Manager of IT\"")
    @Test
    void getEmployeeInfo_Test02() {
        Employee e = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        assertEquals("Dave (ID: 202) - Manager of IT", e.getEmployeeInfo(),
                "the object is a Manager, so its override runs even through an Employee variable");
        Employee e2 = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        assertEquals("Eve (ID: 203) - Manager of Marketing", e2.getEmployeeInfo());
    }
}
