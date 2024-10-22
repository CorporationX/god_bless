package school.faang.helpacolleague;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;
}
