package faang.school.godbless.task.helpAColleague;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Person {
    @ToString.Include
    private String name;
    private String surname;
    private int age;
    private String workplace;
}
