package faang.school.godbless.parallel.help_a_colleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    public PersonNamePrinter(List<Person> person) {
        this.persons = person;
    }

    @Override
    public void run() {
        List<Person> persons = this.persons;
        persons.stream().forEach(p -> System.out.println(p));
    }
}
