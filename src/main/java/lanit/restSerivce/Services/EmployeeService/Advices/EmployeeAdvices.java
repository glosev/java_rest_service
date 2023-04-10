package lanit.restSerivce.Services.EmployeeService.Advices;

import lanit.restSerivce.Services.EmployeeService.Exceptions.EmployeeMissingArgException;
import lanit.restSerivce.Services.EmployeeService.Exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class EmployeeAdvices {

    // Обработчик исключений в случаях, если аргумент отсутствует или его тип не совпадает с указанным;
    @ExceptionHandler(EmployeeMissingArgException.class)
    public ResponseEntity<Map<String, String>> EmployeeMissingArgHandler (EmployeeMissingArgException exception) {
        Map<String, String> errorResponse = Map.of(
                "message", exception.getMessage(),
                "error", HttpStatus.BAD_REQUEST.toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Обработчик исключений в случаях, если по указанному ID запись не найдена;
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, String>> EmployeeNotFoundHandler (EmployeeNotFoundException exception) {
        Map<String, String> errorResponse = Map.of(
                "message", exception.getMessage(),
                "error", HttpStatus.NOT_FOUND.toString()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
