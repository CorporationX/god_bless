package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("Person: %s (%s)\n", person.getName(), Thread.currentThread().getName());
        }
    }
}
