package faang.school.godbless.HelpYourMate;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private final List<Person> persons;

    public PersonNamePrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        persons.forEach(System.out::println);
    }
}
