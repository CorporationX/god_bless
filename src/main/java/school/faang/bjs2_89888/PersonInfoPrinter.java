package school.faang.bjs2_89888;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("name: %s, surname: %s, age: %d, workplace: %s%n",
                    person.name(), person.surname(), person.age(), person.workplace());
        }
    }
}
