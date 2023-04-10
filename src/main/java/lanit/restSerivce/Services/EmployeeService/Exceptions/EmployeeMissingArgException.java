package lanit.restSerivce.Services.EmployeeService.Exceptions;

public class EmployeeMissingArgException extends RuntimeException {
    public EmployeeMissingArgException (String expected, String gotten) {
        super("Expected parameter " + expected + ", got " + gotten);
    }
}