package faang.school.godbless.BJS2_24200;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        people.forEach(System.out::println);
    }
}
