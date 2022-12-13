package EmpApp;

public interface EmployeeInterface {
    public void createEmployee(Employee employee);
    public void showAllEmployee();
    public void showEmployee(int id);
    public void updateEmployee(int id,String name,Double salary);
    public void delete(int id);
}
