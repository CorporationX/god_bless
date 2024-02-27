package faang.school.godbless.helpcollegue;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> persons;

    @Override
    public void run() {
        persons.forEach(person -> System.out.println(person.getName()));
    }
}
