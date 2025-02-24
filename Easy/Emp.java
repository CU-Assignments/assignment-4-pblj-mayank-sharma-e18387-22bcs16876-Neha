import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Emp {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        updateEmployee();
                        break;
                    case 3:
                        removeEmployee();
                        break;
                    case 4:
                        searchEmployee();
                        break;
                    case 5:
                        displayAllEmployees();
                        break;
                    case 6:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Method to add a new employee
    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee newEmployee = new Employee(id, name, salary);
            employeeList.add(newEmployee);
            System.out.println("Employee added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid details.");
        }
    }

    // Method to update employee details
    private static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Employee emp : employeeList) {
                if (emp.getId() == id) {
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new Salary: ");
                    double newSalary = Double.parseDouble(scanner.nextLine());

                    emp.setName(newName);
                    emp.setSalary(newSalary);
                    System.out.println("Employee details updated successfully!");
                    return;
                }
            }
            System.out.println("Employee ID not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid details.");
        }
    }

    // Method to remove an employee
    private static void removeEmployee() {
        try {
            System.out.print("Enter Employee ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Employee emp : employeeList) {
                if (emp.getId() == id) {
                    employeeList.remove(emp);
                    System.out.println("Employee removed successfully!");
                    return;
                }
            }
            System.out.println("Employee ID not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        }
    }

    // search for an employee
    private static void searchEmployee() {
        try {
            System.out.print("Enter Employee ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Employee emp : employeeList) {
                if (emp.getId() == id) {
                    System.out.println("Employee Found: " + emp);
                    return;
                }
            }
            System.out.println("Employee ID not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        }
    }

    // display all employees
    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\nAll Employees:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }
}
