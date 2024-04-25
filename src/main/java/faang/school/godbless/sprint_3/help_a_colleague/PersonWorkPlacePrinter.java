package faang.school.godbless.sprint_3.help_a_colleague;

import java.util.List;

public class PersonWorkPlacePrinter implements Runnable {
    private List<Person> persons;

    public PersonWorkPlacePrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(person.getWorkPlace()));
    }
}