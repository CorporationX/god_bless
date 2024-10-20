package school.faang.helpacolleague;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        persons.stream()
                .forEach(person -> System.out.println(
                        "Name: " + person.getName() +
                                ", Surname: " + person.getSurname() +
                                ", Workplace: " + person.getWorkplace()));
    }
}

