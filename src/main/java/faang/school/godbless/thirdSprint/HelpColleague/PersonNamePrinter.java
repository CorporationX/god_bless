package faang.school.godbless.thirdSprint.HelpColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(person.name()));
    }
}
