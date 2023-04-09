package lanit.restSerivce.Services.EmployeeService.Exceptions;

public class EmployeeMissingArgException extends RuntimeException {
    public EmployeeMissingArgException (String method, String arg, int pos, String gotten) {
        super("Method " + method + ": argument is missing: expected argument " + arg + " at pos " + pos + ", got " + gotten);
    }
}