package faang.school.godbless.help_a_colleague;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workPlace;
}