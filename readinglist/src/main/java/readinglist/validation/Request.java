package readinglist.validation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Taqwa It on 3/31/2017.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Request {

    String name;
    Integer age;
    Address address;
}
