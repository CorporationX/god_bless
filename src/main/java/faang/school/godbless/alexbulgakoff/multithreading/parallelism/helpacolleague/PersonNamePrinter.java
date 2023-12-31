package faang.school.godbless.alexbulgakoff.multithreading.parallelism.helpacolleague;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@ToString
public class PersonNamePrinter implements Runnable {

    private List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println("Имя сотрудника: " + person.getName() + " вывод в потоке: " + Thread.currentThread().getName());
        }
    }
}
