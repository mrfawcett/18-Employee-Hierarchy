import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExecutiveTest {
    
    @DisplayName("Constructor Test 1")
    @Test
    void constructor_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertNotNull(exec);
    }
    
    @DisplayName("Constructor Test 2")
    @Test
    void constructor_Test02() {
        Executive exec1 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        Executive exec2 = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        assertNotNull(exec1);
        assertNotNull(exec2);
    }
    
    @DisplayName("getStockOptions Test 1")
    @Test
    void getStockOptions_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        double expected = 50000.0;
        double result = exec.getStockOptions();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getStockOptions Test 2")
    @Test
    void getStockOptions_Test02() {
        Executive exec = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        double expected = 60000.0;
        double result = exec.getStockOptions();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getStockOptions Test 3")
    @Test
    void getStockOptions_Test03() {
        Executive exec = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        double expected = 70000.0;
        double result = exec.getStockOptions();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 1")
    @Test
    void calculatePay_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        double expected = 237500.0;
        double result = exec.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 2")
    @Test
    void calculatePay_Test02() {
        Executive exec = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        double expected = 268000.0;
        double result = exec.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 3")
    @Test
    void calculatePay_Test03() {
        Executive exec = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        double expected = 299500.0;
        double result = exec.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 4")
    @Test
    void calculatePay_Test04() {
        Executive exec = new Executive("Irene", 304, 200000.0, "Legal", 0.20, 80000.0);
        double expected = 320000.0;
        double result = exec.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getEmployeeInfo Test 1")
    @Test
    void getEmployeeInfo_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        String expected = "Frank (ID: 301) - Executive of Operations";
        String result = exec.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 2")
    @Test
    void getEmployeeInfo_Test02() {
        Executive exec = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        String expected = "Grace (ID: 302) - Executive of Finance";
        String result = exec.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 3")
    @Test
    void getEmployeeInfo_Test03() {
        Executive exec = new Executive("Henry", 303, 170000.0, "Technology", 0.35, 70000.0);
        String expected = "Henry (ID: 303) - Executive of Technology";
        String result = exec.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 1 - Can supervise HourlyEmployee")
    @Test
    void canSupervise_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 40);
        boolean expected = true;
        boolean result = exec.canSupervise(emp);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 2 - Can supervise regular Employee")
    @Test
    void canSupervise_Test02() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Employee emp = new Employee("George", 105, 50000.0);
        boolean expected = true;
        boolean result = exec.canSupervise(emp);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 3 - Can supervise Manager")
    @Test
    void canSupervise_Test03() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        boolean expected = true;
        boolean result = exec.canSupervise(mgr);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 4 - Can supervise another Executive")
    @Test
    void canSupervise_Test04() {
        Executive exec1 = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Executive exec2 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        boolean expected = true;
        boolean result = exec1.canSupervise(exec2);
        assertEquals(expected, result);
    }
    
    @DisplayName("canSupervise Test 5 - Can supervise multiple employee types")
    @Test
    void canSupervise_Test05() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Executive exec2 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        
        boolean result1 = exec.canSupervise(emp1);
        boolean result2 = exec.canSupervise(mgr);
        boolean result3 = exec.canSupervise(exec2);
        
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }
    
    @DisplayName("canSupervise Test 6 - Always returns true")
    @Test
    void canSupervise_Test06() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Employee emp = new Employee("John", 999, 40000.0);
        boolean expected = true;
        boolean result = exec.canSupervise(emp);
        assertEquals(expected, result);
    }
}