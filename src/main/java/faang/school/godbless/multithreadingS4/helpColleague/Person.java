package faang.school.godbless.multithreadingS4.helpColleague;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;
}
