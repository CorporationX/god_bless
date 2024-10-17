package school.faang.help.colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        persons.forEach(System.out::println);
    }
}
