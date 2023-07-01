package faang.school.godbless.thread.helpCollegaue;

import lombok.Getter;

@Getter
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;


    public Person(String name) {
        this.name = name;
    }
}
