package lanit.restSerivce.Services.EmployeeService;

import lanit.restSerivce.Entities.Employee;
import lanit.restSerivce.Services.EmployeeService.Exceptions.EmployeeMissingArgException;
import lanit.restSerivce.Services.EmployeeService.Exceptions.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class LocalEmployeeService implements EmployeeServiceIf {

    private List<Employee> employeeList = new ArrayList<>();
    @PostMapping("/employee/add")
    @Override
    public Employee addEmployee(String name, String surname, String role) {
        if (name    == null)    throw new EmployeeMissingArgException("employee/add", "name",    1, "null");
        if (surname == null)    throw new EmployeeMissingArgException("employee/add", "surname", 2, "null");
        if (role    == null)    throw new EmployeeMissingArgException("employee/add", "role",    3, "null");

        var emp = new Employee(name, surname);
        emp.setRole(role);
        employeeList.add(emp);
        return emp;
    }

    @GetMapping("/employee/{id}")
    @Override
    public Employee getEmployeeFromId(@PathVariable String id) {
        var uid = UUID.fromString(id);
        for (Employee emp: employeeList) {
            if (emp.id.equals(uid)) {
                return emp;
            }
        }

        throw new EmployeeNotFoundException(uid);
    }

    @GetMapping("/employee/list")
    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @PatchMapping("/employee/{id}")
    @Override
    public Employee editEmployee(@PathVariable String id, String name, String surname, String role) {
        var emp = getEmployeeFromId(id);

        if (name    != null)    emp.setName(name);
        if (surname != null)    emp.setSurname(surname);
        if (role    != null)    emp.setRole(role);

        return emp;
    }

    @DeleteMapping("/employee/{id}")
    @Override
    public void removeEmployee(@PathVariable String id) {
        var emp = getEmployeeFromId(id);
        employeeList.remove(emp);
    }
}