package helping;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> System.out.printf("%s : %s%n", person.getName(), person.getWorkplace()));
    }
}
