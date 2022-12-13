package EmpApp;

import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int preference;
        EmployeeCRUD crud=new EmployeeCRUD();

        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION");
        System.out.println("");

        do {
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee \n" +
                    "4. Update the Employee\n" +
                    "5. Delete the Employee\n" +
                    "6. Exit the program");
            System.out.print("Enter your preference:");
            preference=scanner.nextInt();
            switch (preference){
                case 1:
                    Employee employee=getEmpCreate();
                    crud.createEmployee(employee);
                    break;
                case 2:
                    crud.showAllEmployee();
                    break;
                case 3:
                    crud.showEmployee(getEmployeeId());
                    break;
                case 4:
                    crud.updateEmployee(getEmployeeId(),getEmployeeName(),getEmployeeSalary());
                    break;
                case 5:
                    crud.delete(getEmployeeId());
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid preference");
                    break;
            }
        }while (true);
    }

    private static Employee getEmpCreate(){
        System.out.print("Enter employee id: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name=scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary=scanner.nextDouble();

        System.out.print("Enter employee age: ");
        int age=scanner.nextInt();
        scanner.nextLine();

        return (new Employee(id,name,salary,age));
    }

    private static String getEmployeeName(){
        System.out.print("Enter employee Name: ");
        return (scanner.nextLine());
    }

    private static double getEmployeeSalary(){
        System.out.print("Enter employee Salary: ");
        return (scanner.nextDouble());
    }

    private static int getEmployeeId(){
        System.out.print("Enter employee id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}
