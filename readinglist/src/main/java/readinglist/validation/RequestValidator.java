package readinglist.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Taqwa It on 3/31/2017.
 */
public class RequestValidator implements Validator {

    private final Validator addressValidator;

    public RequestValidator(Validator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Request.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "request.name", "name must not null");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "request.age", "age must not null");
        Request request = (Request) target;
        ValidationUtils.rejectIfEmpty(errors,"address","request.address","address cannot be null");
        if (request.getAge() != null && request.getAge() < 0) {
            errors.reject("request.age", "age must be greater than 0");
        }

        if (request.getAddress() != null) {
            try {
                errors.pushNestedPath("address");
                ValidationUtils.invokeValidator(this.addressValidator, request.getAddress(), errors);
            } finally {
                errors.popNestedPath();
            }
        }
    }
}
