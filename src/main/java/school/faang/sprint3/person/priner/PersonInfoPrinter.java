package school.faang.sprint3.person.priner;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> people;

    @Override
    public void run() {
        people.forEach(person ->
                System.out.printf("%s %s\n", Thread.currentThread().getName(), person)
        );
    }
}
