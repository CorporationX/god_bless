package faang.school.godbless.helpColleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private final List<Person> people;

    public PersonNamePrinter(List<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        people.forEach(person -> System.out.println(person.getName()));
    }
}
