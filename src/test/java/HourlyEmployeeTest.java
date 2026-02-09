import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HourlyEmployeeTest {
    
    @DisplayName("Constructor Test 1")
    @Test
    void constructor_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        assertNotNull(emp);
    }
    
    @DisplayName("Constructor Test 2")
    @Test
    void constructor_Test02() {
        HourlyEmployee emp1 = new HourlyEmployee("Bob", 102, 20.00, 45);
        HourlyEmployee emp2 = new HourlyEmployee("Charlie", 103, 18.50, 40);
        assertNotNull(emp1);
        assertNotNull(emp2);
    }
    
    @DisplayName("getHourlyRate Test 1")
    @Test
    void getHourlyRate_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        double expected = 15.00;
        double result = emp.getHourlyRate();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getHourlyRate Test 2")
    @Test
    void getHourlyRate_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        double expected = 20.00;
        double result = emp.getHourlyRate();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getHourlyRate Test 3")
    @Test
    void getHourlyRate_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        double expected = 18.50;
        double result = emp.getHourlyRate();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getHoursWorked Test 1")
    @Test
    void getHoursWorked_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        double expected = 35;
        double result = emp.getHoursWorked();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getHoursWorked Test 2")
    @Test
    void getHoursWorked_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        double expected = 45;
        double result = emp.getHoursWorked();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getHoursWorked Test 3")
    @Test
    void getHoursWorked_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        double expected = 40;
        double result = emp.getHoursWorked();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 1 - No overtime")
    @Test
    void calculatePay_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        double expected = 525.0;
        double result = emp.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 2 - With overtime")
    @Test
    void calculatePay_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        double expected = 950.0;
        double result = emp.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 3 - Exactly 40 hours")
    @Test
    void calculatePay_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        double expected = 740.0;
        double result = emp.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 4 - Large overtime")
    @Test
    void calculatePay_Test04() {
        HourlyEmployee emp = new HourlyEmployee("Diana", 104, 25.00, 50);
        double expected = 1375.0;
        double result = emp.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("calculatePay Test 5 - Small hours")
    @Test
    void calculatePay_Test05() {
        HourlyEmployee emp = new HourlyEmployee("Eve", 105, 12.00, 20);
        double expected = 240.0;
        double result = emp.calculatePay();
        assertEquals(expected, result, 0.01);
    }
    
    @DisplayName("getEmployeeInfo Test 1")
    @Test
    void getEmployeeInfo_Test01() {
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 35);
        String expected = "Alice (ID: 101) - Hourly: $15.0";
        String result = emp.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 2")
    @Test
    void getEmployeeInfo_Test02() {
        HourlyEmployee emp = new HourlyEmployee("Bob", 102, 20.00, 45);
        String expected = "Bob (ID: 102) - Hourly: $20.0";
        String result = emp.getEmployeeInfo();
        assertEquals(expected, result);
    }
    
    @DisplayName("getEmployeeInfo Test 3")
    @Test
    void getEmployeeInfo_Test03() {
        HourlyEmployee emp = new HourlyEmployee("Charlie", 103, 18.50, 40);
        String expected = "Charlie (ID: 103) - Hourly: $18.5";
        String result = emp.getEmployeeInfo();
        assertEquals(expected, result);
    }
}