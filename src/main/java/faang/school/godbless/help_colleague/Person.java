package faang.school.godbless.help_colleague;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Person {
    private final String name;
    private String surname;
    private int age;
    private String workplace;
}
