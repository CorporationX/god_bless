package school.faang.task_48555;

import lombok.Getter;

@Getter
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;

    public Person(String name, String surname, int age, String workplace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
    }
}
