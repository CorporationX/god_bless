package faang.school.godbless.sprint4.multithreading_parallelism_thread.task3;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge() + " " + person.getWorkplace()));
    }
}
