package faang.school.godbless.help_colleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    public PersonNamePrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
