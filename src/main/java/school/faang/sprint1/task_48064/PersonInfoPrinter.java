package school.faang.sprint1.task_48064;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    public PersonInfoPrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getSurname()
                    + " " + person.getAge() + " " + person.getWorkplace());
        }
    }
}
