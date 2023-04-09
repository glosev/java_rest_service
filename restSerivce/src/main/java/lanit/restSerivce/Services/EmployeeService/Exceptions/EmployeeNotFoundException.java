package lanit.restSerivce.Services.EmployeeService.Exceptions;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(UUID id) {
        super("Couldn't find employee with ID " + id);
    }
}
