package lanit.restSerivce.Services.EmployeeService;

import lanit.restSerivce.Entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeServiceIf {
    Employee addEmployee(String name, String surname, String role);
    public Employee getEmployeeFromUUID(UUID uuid);
    public Employee getEmployeeFromID(int id);
    Employee getEmployeeFromSpecifiedIdentifier(String id);
    List<Employee> getEmployeeList();
    Employee editEmployee(String id, String name, String surname, String role);
    void removeEmployee(String id);
}
