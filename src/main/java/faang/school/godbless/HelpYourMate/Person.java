package faang.school.godbless.HelpYourMate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;
}
