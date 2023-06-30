package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("Person: %s works at %s (%s)\n",
                    person.getName(), person.getWorkplace(), Thread.currentThread().getName());
        }
    }
}
