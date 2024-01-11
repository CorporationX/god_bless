package faang.school.godbless.alexbulgakoff.multithreading.parallelism.helpacolleague;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Person {

    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(String name) {
        this.name = name;
    }
}
