package persistence;

import domain.Employee;
import java.util.List;

public interface IEmployeeMapper {

    public List<Employee> getAllEmployees();
}
