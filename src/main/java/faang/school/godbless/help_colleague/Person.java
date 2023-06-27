package faang.school.godbless.help_colleague;

import lombok.Getter;

public class Person {
    @Getter
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(String name) {
        this.name = name;
    }
}
