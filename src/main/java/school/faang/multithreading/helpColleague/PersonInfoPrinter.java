package school.faang.multithreading.helpColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(person.toString()));
    }
}
