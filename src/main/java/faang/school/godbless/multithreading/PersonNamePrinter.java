package faang.school.godbless.multithreading;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        people.forEach(person -> System.out.println(person.getName()));
    }
}
