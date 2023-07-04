package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> workers;

    @Override
    public void run() {
        for (Person person : workers) {
            System.out.println(person.getWorkplace() + " " + Thread.currentThread().getName());
        }
    }
}
