package school.faang.task_60576;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> {
            System.out.printf("%s, %s, %d, %s\n", person.getName(), person.getSurname(),
                    person.getAge(), person.getWorkplace());
        });
    }
}
