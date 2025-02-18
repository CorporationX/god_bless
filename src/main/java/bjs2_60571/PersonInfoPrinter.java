package bjs2_60571;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    public PersonInfoPrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("Name = %s, surname = %s, workplace = %s%n", person.name(), person.surname(), person.workplace());
        }
    }
}
