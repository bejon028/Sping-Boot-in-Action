package readinglist.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Taqwa It on 3/31/2017.
 */
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"street","address.street","street cannot be null");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city","address.city","city cannot be null");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"country","address.country","country cannot be null");
    }
}
