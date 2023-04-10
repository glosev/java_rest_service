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
    private int instanceCount = 0;

    private final List<Employee> employeeList = new ArrayList<>();

    // Поиск записи по целочисленному ID
    @Override
    public Employee getEmployeeFromID(int id) {
        for (Employee emp: employeeList) {
            if (emp.id == id) {
                return emp;
            }
        }

        throw new EmployeeNotFoundException(Integer.toString(id));
    }

    // Поиск записи по UUID
    @Override
    public Employee getEmployeeFromUUID(UUID uuid) {
        for (Employee emp: employeeList) {
            if (emp.uuid.equals(uuid)) {
                return emp;
            }
        }

        throw new EmployeeNotFoundException(uuid.toString());
    }

    @PostMapping("/employees")
    @Override
    public Employee addEmployee(String name, String surname, String role) {
        if (name    == null)    throw new EmployeeMissingArgException("String name",    "null");
        if (surname == null)    throw new EmployeeMissingArgException("String surname", "null");
        if (role    == null)    throw new EmployeeMissingArgException("String role",    "null");

        var emp = new Employee(name, surname, instanceCount++);
        emp.setRole(role);
        employeeList.add(emp);
        return emp;
    }

    @GetMapping("/employees/{identifier}")
    @Override
    public Employee getEmployeeFromSpecifiedIdentifier(@PathVariable String identifier) {
        UUID uid;
        int id;

        try {id = Integer.parseInt(identifier);}
        catch (Exception firstErr) {
            try {uid = UUID.fromString(identifier);}
            catch (Exception secondErr) {
                throw new EmployeeMissingArgException("String identifier", "Nonconvertible String " + identifier);
            }
            return this.getEmployeeFromUUID(uid);
        }

        return this.getEmployeeFromID(id);
    }

    @GetMapping("/employees")
    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @PatchMapping("/employees/{id}")
    @Override
    public Employee editEmployee(@PathVariable String id, String name, String surname, String role) {
        var emp = getEmployeeFromSpecifiedIdentifier(id);

        if (name    != null)    emp.setName(name);
        if (surname != null)    emp.setSurname(surname);
        if (role    != null)    emp.setRole(role);

        return emp;
    }

    @DeleteMapping("/employees/{id}")
    @Override
    public void removeEmployee(@PathVariable String id) {
        var emp = getEmployeeFromSpecifiedIdentifier(id);
        employeeList.remove(emp);
    }
}