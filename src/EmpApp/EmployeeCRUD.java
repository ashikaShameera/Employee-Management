package EmpApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeCRUD implements EmployeeInterface{

    private Connection connection=DatabaseConnection.createDatabaseConnection();;
    private String query;


    @Override
    public void createEmployee(Employee employee) {
        query="insert into employee values(?,?,?,?)";
        try {
            //PreparedStatement will be used for executing SQL statements many times dynamically.
            //It will accept input parameters.
            PreparedStatement pSTM=connection.prepareStatement(query);
            pSTM.setInt(1,employee.getId());
            pSTM.setString(2,employee.getName());
            pSTM.setDouble(3,employee.getSalary());
            pSTM.setInt(4,employee.getAge());

            int count=pSTM.executeUpdate();

            if (count!=0)
                System.out.println("Employee Inserted Successfully!!!");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        query="select * from employee";
        try{
            //Statement will be used for executing static SQL statements and it can't accept input parameters.
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(query);

            System.out.println("EMPLOYEE DETAILS");
            System.out.format("%s\t%s\t\t%s\t\t%s\n","ID","AGE","SALARY","NAME");
            while (result.next()){
                System.out.format("%d\t%d\t%f\t%s\n",
                        result.getInt(1),
                        result.getInt(4),
                        result.getDouble(3),
                        result.getString(2));
            }
            System.out.println("-----------------------------------------------");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void showEmployee(int idEmployee) {
        query="select * from employee where idEmployee="+idEmployee;
        System.out.println(query);
        try{

            Statement statement=connection.createStatement();
            ResultSet result= statement.executeQuery(query);

            System.out.println("-----------------------------------------------");
            System.out.format("%s\t%s\t%s\t\t%s\n","ID","AGE","SALARY","NAME");
            while (result.next()){
                System.out.format("%d\t%d\t%f\t%s\n",
                        result.getInt(1),
                        result.getInt(4),
                        result.getDouble(3),
                        result.getString(2));
            }
            System.out.println("-----------------------------------------------");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int idEmployee,String name,Double salary) {
        query="Update employee set name=?,salary=? where idEmployee=?";
        try {
            PreparedStatement pSTM=connection.prepareStatement(query);
            pSTM.setString(1,name);
            pSTM.setDouble(2,salary);
            pSTM.setInt(3,idEmployee);

            int count=pSTM.executeUpdate();
            if(count!=0)
                System.out.println("UPDATE SUCCESSFULLY !!!!");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void delete(int idEmployee) {
        query="delete from employee where idEmployee=?";
        try {
            System.out.println(idEmployee);
            PreparedStatement pSTM=connection.prepareStatement(query);
            pSTM.setInt(1,idEmployee);

            int count=pSTM.executeUpdate();
            if(count!=0)
                System.out.println("Employee Deleted Successfully!!!!");
        }catch (Exception err){
            err.printStackTrace();
        }
    }
}
