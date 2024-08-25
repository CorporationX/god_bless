package faang.school.godbless.helpColleague;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workspace;

    public Person(String name) {
        this.name = name;
    }
}
