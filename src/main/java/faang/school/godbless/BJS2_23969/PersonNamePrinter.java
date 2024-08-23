package faang.school.godbless.BJS2_23969;

import java.util.List;

public class PersonNamePrinter implements Runnable {

    private final List<Person> persons;

    public PersonNamePrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(Thread.currentThread().getName() + ": Person's name: " + person.getName()));
    }
}