package persistence;

import static persistence.DB.getConnection;
import domain.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeMapper implements IEmployeeMapper {

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList();
        String sql = "select * from emp";
        ResultSet rs = null;
        try {
            rs = getConnection().prepareStatement(sql).executeQuery();
        } catch (SQLException ex) {
        }

        Employee emp = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("empNo");
                String ename = rs.getString("ename");
                int sal = rs.getInt("sal");
                int comm = rs.getInt("comm");
                emp = new Employee(id, ename, sal, comm);
                emps.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    public static void main(String[] args) {
        IEmployeeMapper em = new EmployeeMapper();
        try {
            for (Employee emp : em.getAllEmployees()) {
                System.out.println(emp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
