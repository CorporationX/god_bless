package school.faang.help_the_college;

import lombok.Getter;

@Getter
public class Person {
    private final String name;
    public final String surname;
    private final int age;
    private final String workplace;

    public Person(String name, String surname, String workplace) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.workplace = workplace;
    }
}
