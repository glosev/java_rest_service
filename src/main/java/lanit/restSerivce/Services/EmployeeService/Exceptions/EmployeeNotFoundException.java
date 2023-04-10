package lanit.restSerivce.Services.EmployeeService.Exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("Couldn't find employee with ID " + id);
    }
}
