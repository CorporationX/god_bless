package school.faang.task48090;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> people;

    @Override
    public void run() {
        people.forEach(person -> log.info(person.toString()));
    }
}
