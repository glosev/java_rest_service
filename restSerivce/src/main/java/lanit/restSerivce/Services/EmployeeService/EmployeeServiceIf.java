package lanit.restSerivce.Services.EmployeeService;

import lanit.restSerivce.Entities.Employee;

import java.util.List;

public interface EmployeeServiceIf {
    Employee addEmployee(String name, String surname, String role);
    Employee getEmployeeFromId(String id);
    List<Employee> getEmployeeList();
    Employee editEmployee(String id, String name, String surname, String role);
    void removeEmployee(String id);
}
