package school.faang.helpacolleague;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String workplace;
}
