package help_collegue;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonNamePrinter implements Runnable {
    private final List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.workplace());
        }
    }
}
