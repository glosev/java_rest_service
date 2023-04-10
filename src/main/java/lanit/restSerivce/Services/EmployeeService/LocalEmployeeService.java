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
    @PostMapping("/employees")
    @Override
    public Employee addEmployee(String name, String surname, String role) {
        if (name    == null)    throw new EmployeeMissingArgException("String name",    "null");
        if (surname == null)    throw new EmployeeMissingArgException("String surname", "null");
        if (role    == null)    throw new EmployeeMissingArgException("String role",    "null");

        var emp = new Employee(name, surname);
        emp.setRole(role);
        employeeList.add(emp);
        return emp;
    }

    @GetMapping("/employees/{id}")
    @Override
    public Employee getEmployeeFromId(@PathVariable String id) {
        UUID uid;

        try {uid = UUID.fromString(id);}
        catch (Exception exception) {throw new EmployeeMissingArgException("UUID id", "Nonconvertible String " + id);}

        for (Employee emp: employeeList) {
            if (emp.id.equals(uid)) {
                return emp;
            }
        }

        throw new EmployeeNotFoundException(uid);
    }

    @GetMapping("/employees")
    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @PatchMapping("/employees/{id}")
    @Override
    public Employee editEmployee(@PathVariable String id, String name, String surname, String role) {
        var emp = getEmployeeFromId(id);

        if (name    != null)    emp.setName(name);
        if (surname != null)    emp.setSurname(surname);
        if (role    != null)    emp.setRole(role);

        return emp;
    }

    @DeleteMapping("/employees/{id}")
    @Override
    public void removeEmployee(@PathVariable String id) {
        var emp = getEmployeeFromId(id);
        employeeList.remove(emp);
    }
}