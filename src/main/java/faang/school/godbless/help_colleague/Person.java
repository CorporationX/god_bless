package faang.school.godbless.help_colleague;

import lombok.Getter;
@Getter
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(String name, String workplace) {
        this.name = name;
        this.workplace = workplace;
    }
}
