package faang.school.godbless.task.helpAColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        persons.forEach(System.out::println);
    }
}
