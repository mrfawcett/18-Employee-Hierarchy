import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CanSuperviseTest {

    @DisplayName("Manager.canSupervise: an HourlyEmployee -> true")
    @Test
    void manager_Test01() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 40);
        assertEquals(true, mgr.canSupervise(emp), "a manager supervises hourly employees");
    }

    @DisplayName("Manager.canSupervise: a plain Employee -> true")
    @Test
    void manager_Test02() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Employee emp = new Employee("George", 105, 50000.0);
        assertEquals(true, mgr.canSupervise(emp), "a manager supervises regular employees");
    }

    @DisplayName("Manager.canSupervise: another Manager -> false")
    @Test
    void manager_Test03() {
        Manager mgr1 = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Manager mgr2 = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        assertEquals(false, mgr1.canSupervise(mgr2), "managers do not supervise other managers");
    }

    @DisplayName("Manager.canSupervise: an Executive -> false (an Executive IS a Manager)")
    @Test
    void manager_Test04() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals(false, mgr.canSupervise(exec), "Executive extends Manager, so 'emp instanceof Manager' is true for an Executive");
    }

    @DisplayName("Manager.canSupervise: the parameter is declared Employee but instanceof looks at the OBJECT (Employee e = new Manager(...) -> false)")
    @Test
    void manager_Test05() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Employee hidden = new Manager("Dave", 202, 85000.0, "IT", 0.20);
        assertEquals(false, mgr.canSupervise(hidden), "the variable type does not matter; the object is a Manager");
        Employee plain = new Employee("George", 105, 50000.0);
        assertEquals(true, mgr.canSupervise(plain));
    }

    @DisplayName("Manager.canSupervise: several hourly employees -> true for each")
    @Test
    void manager_Test06() {
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
        HourlyEmployee emp2 = new HourlyEmployee("Bob", 102, 20.00, 45);
        assertTrue(mgr.canSupervise(emp1), "Alice");
        assertTrue(mgr.canSupervise(emp2), "Bob");
    }

    @DisplayName("Executive.canSupervise: an HourlyEmployee -> true")
    @Test
    void executive_Test01() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        HourlyEmployee emp = new HourlyEmployee("Alice", 101, 15.00, 40);
        assertEquals(true, exec.canSupervise(emp));
    }

    @DisplayName("Executive.canSupervise: plain Employees -> true (George, John)")
    @Test
    void executive_Test02() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        assertEquals(true, exec.canSupervise(new Employee("George", 105, 50000.0)));
        assertEquals(true, exec.canSupervise(new Employee("John", 999, 40000.0)), "always true, whoever it is");
    }

    @DisplayName("Executive.canSupervise: a Manager -> true (this is where Executive differs from Manager)")
    @Test
    void executive_Test03() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals(true, exec.canSupervise(mgr), "an executive supervises managers - the Manager version would say false");
    }

    @DisplayName("Executive.canSupervise: another Executive -> true")
    @Test
    void executive_Test04() {
        Executive exec1 = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Executive exec2 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        assertEquals(true, exec1.canSupervise(exec2));
    }

    @DisplayName("Executive.canSupervise: every kind of employee at once -> true, true, true")
    @Test
    void executive_Test05() {
        Executive exec = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        HourlyEmployee emp1 = new HourlyEmployee("Alice", 101, 15.00, 40);
        Manager mgr = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        Executive exec2 = new Executive("Grace", 302, 160000.0, "Finance", 0.30, 60000.0);
        assertTrue(exec.canSupervise(emp1), "hourly");
        assertTrue(exec.canSupervise(mgr), "manager");
        assertTrue(exec.canSupervise(exec2), "executive");
    }

    @DisplayName("dynamic dispatch: Manager m = new Executive(...); m.canSupervise(aManager) -> true (Executive's override wins)")
    @Test
    void executive_Test06() {
        Manager m = new Executive("Frank", 301, 150000.0, "Operations", 0.25, 50000.0);
        Manager other = new Manager("Carol", 201, 80000.0, "Sales", 0.15);
        assertEquals(true, m.canSupervise(other),
                "the variable says Manager, but the object is an Executive, so Executive.canSupervise runs");
    }
}
