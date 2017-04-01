package readinglist.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Taqwa It on 3/31/2017.
 */
@Slf4j
@RestController
@RequestMapping("validation")
public class ValidationController {

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new RequestValidator(new AddressValidator()));
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody Request request) {
        System.out.println(request);
    }
}
