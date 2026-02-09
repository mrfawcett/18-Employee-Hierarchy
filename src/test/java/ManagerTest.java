import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    
    @DisplayName("Constructor Test 1")
    @Test
    void constructor_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertNotNull(mgr);
    }
    
    @DisplayName("Constructor Test 2")
    @Test
    void constructor_Test02() {
        Manager mgr1 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        Manager mgr2 = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        assertNotNull(mgr1);
        assertNotNull(mgr2);
    }
    
    @DisplayName("getDepartment Test 1")
    @Test
    void getDepartment_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        String expected = "Sales";
        String result = mgr.getDepartment();
        assertEquals(expected, result);
    }
    
    @DisplayName("getDepartment Test 2")
    @Test
    void getDepartment_Test02() {
        Manager mgr = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        String expected = "IT";
        String result = mgr.getDepartment();
        assertEquals(expected, result);
    }
    
    @DisplayName("getDepartment Test 3")
    @Test
    void getDepartment_Test03() {
        Manager mgr = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        String expected = "Marketing";
        String result = mgr.getDepartment();
        assertEquals(expected, result);
    }
    
    @DisplayName("getBonusPercent Test 1")
    @Test
    void getBonusPercent_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        double expected = 0.15;
        double result = mgr.getBonusPercent();
        assertEquals(expected, result, 0.001);
    }
    
    @DisplayName("getBonusPercent Test 2")
    @Test
    void getBonusPercent_Test02() {
        Manager mgr = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        double expected = 0.20;
        double result = mgr.getBonusPercent();
        assertEquals(expected, result, 0.001);
    }
    
    @DisplayName("getBonusPercent Test 3")
    @Test
    void getBonusPercent_Test03() {
        Manager mgr = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        double expected = 0.10;
        double result = mgr.getBonusPercent();
        assertEquals(expected, result, 0.001);
    }
    
    @DisplayName("calculatePay Test 1")
    @Test
    void calculatePay_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        double expected = 92000.0;
        double result = mgr.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 2")
    @Test
    void calculatePay_Test02() {
        Manager mgr = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        double expected = 102000.0;
        double result = mgr.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 3")
    @Test
    void calculatePay_Test03() {
        Manager mgr = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        double expected = 99000.0;
        double result = mgr.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 4")
    @Test
    void calculatePay_Test04() {
        Manager mgr = new Manager("Frank", 204, 100000.0, "Finance", 0.25);
        double expected = 125000.0;
        double result = mgr.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getEmployeeInfo Test 1")
    @Test
    void getEmployeeInfo_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        String expected = "Carol (ID: 201) - Manager of Sales";
        String result = mgr.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 2")
    @Test
    void getEmployeeInfo_Test02() {
        Manager mgr = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        String expected = "Dave (ID: 202) - Manager of IT";
        String result = mgr.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 3")
    @Test
    void getEmployeeInfo_Test03() {
        Manager mgr = new Manager("Eve", 203, 90000.0, "Marketing", 0.10);
        String expected = "Eve (ID: 203) - Manager of Marketing";
        String result = mgr.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 1 - Can supervise HourlyEmployee")
    @Test
    void canSupervise_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 40);
        boolean expected = true;
        boolean result = mgr.canSupervise(emp);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 2 - Can supervise regular Employee")
    @Test
    void canSupervise_Test02() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Employee emp = new Employee("George", 105, 50000.0);
        boolean expected = true;
        boolean result = mgr.canSupervise(emp);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 3 - Cannot supervise another Manager")
    @Test
    void canSupervise_Test03() {
        Manager mgr1 = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        boolean expected = false;
        boolean result = mgr1.canSupervise(mgr2);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 4 - Cannot supervise Executive")
    @Test
    void canSupervise_Test04() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        boolean expected = false;
        boolean result = mgr.canSupervise(exec);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 5 - Multiple HourlyEmployees")
    @Test
    void canSupervise_Test05() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
        HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
        boolean result1 = mgr.canSupervise(emp1);
        boolean result2 = mgr.canSupervise(emp2);
        assertTrue(result1);
        assertTrue(result2);
    }
}