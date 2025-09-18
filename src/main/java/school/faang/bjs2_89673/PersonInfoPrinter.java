package school.faang.bjs2_89673;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("Name: %s, Surname: %s, Age: %d, Workplace: %s%n",
                    person.getName(),
                    person.getSurname(),
                    person.getAge(),
                    person.getWorkplace());
        }
    }
}
