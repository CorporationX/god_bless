package school.faang.m1s3.bjs2_35956_helpColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> personList;

    @Override
    public void run() {
        personList.forEach(person -> {
            System.out.printf("Thread id #%d --- Name: %s, Surname: %s, Workplace: %s%n",
                    Thread.currentThread().getId(), person.getName(), person.getSurname(), person.getWorkplace());
        });
    }
}
