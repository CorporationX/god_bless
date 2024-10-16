package school.faang.task318.person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;
}
