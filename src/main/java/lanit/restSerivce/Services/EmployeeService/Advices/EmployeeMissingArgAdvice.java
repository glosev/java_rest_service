package lanit.restSerivce.Services.EmployeeService.Advices;

import lanit.restSerivce.Services.EmployeeService.Exceptions.EmployeeMissingArgException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeMissingArgAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeMissingArgException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String EmployeeMissingArgHandler (EmployeeMissingArgException exception) {
        return exception.getMessage();
    }
}
