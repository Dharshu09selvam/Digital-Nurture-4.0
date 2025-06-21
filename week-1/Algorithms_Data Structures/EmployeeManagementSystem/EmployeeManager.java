import java.util.Scanner;

public class EmployeeManager {
    Employee[] employees = new Employee[100];
    int count = 0;

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee list full.");
        }
    }

    public void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void listEmployees() {
        if (count == 0) {
            System.out.println("No employees.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Alice", "Manager", 80000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(3, "Dharshini", "Analyst", 50000));

        System.out.println("\nAll Employees:");
        manager.listEmployees();

        System.out.println("\nSearch for Employee ID 2:");
        manager.searchEmployee(2);

        System.out.println("\nDeleting Employee ID 2:");
        manager.deleteEmployee(2);

        System.out.println("\nEmployees after deletion:");
        manager.listEmployees();
    }
}
