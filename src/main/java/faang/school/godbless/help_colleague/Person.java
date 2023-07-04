package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    private String surname;
    private int age;
    private String workplace;
}
