package school.faang.task48090;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> people;

    @Override
    public void run() {
        people.forEach(System.out::println);
    }
}
