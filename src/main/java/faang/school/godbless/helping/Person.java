package faang.school.godbless.helping;

import lombok.Getter;

@Getter
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;

    public Person(int index) {
        this.name = Integer.toString(index);
        this.surname = Integer.toString(index);
        this.workplace = Integer.toString(index);
        this.age = index;
    }
}
