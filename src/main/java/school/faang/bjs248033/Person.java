package school.faang.bjs248033;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;
}
