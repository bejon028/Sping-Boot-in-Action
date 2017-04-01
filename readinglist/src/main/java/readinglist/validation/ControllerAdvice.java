package readinglist.validation;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Taqwa It on 3/31/2017.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleRequestError(MethodArgumentNotValidException exception) {
        ErrorResponse response = new ErrorResponse();
        BindingResult bindingResult = exception.getBindingResult();
        if(bindingResult.getFieldErrorCount() > 0) {
            response.setErrorResponse(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }else{
            response.setErrorResponse(bindingResult.getGlobalError().getDefaultMessage()+"");
        }
        return response;
    }

}
