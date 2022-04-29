package az.iktlab.groupj4web.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Person {

    Long id;
    private String name;
    private String surname;
    private int age;
    private boolean isActive;


}