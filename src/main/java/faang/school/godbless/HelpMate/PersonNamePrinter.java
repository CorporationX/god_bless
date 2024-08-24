package faang.school.godbless.HelpMate;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> people;

    @Override
    public void run() {
        people.forEach(p -> System.out.println(p.getName()));
    }
}
