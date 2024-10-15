package help_a_colleague;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> persons;

    /**
     * Prints the name, surname, and workplace of each person in the list.
     *
     * <p>This method is intended to be called from a thread.
     */
    @Override
    public void run() {
        persons.forEach(person -> System.out.printf("Name: %s, Surname: %s, Workplace: %s%n", person.getName(), person.getSurname(), person.getWorkplace()));
    }
}
