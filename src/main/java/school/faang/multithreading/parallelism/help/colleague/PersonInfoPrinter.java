package school.faang.multithreading.parallelism.help.colleague;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> persons;

    @Override
    public void run() {
        log.info("Поток {} выводит информацию: ", Thread.currentThread().getName());
        persons.forEach(
                person -> log.info("Person name {}, surname {}, workplace {}", person.getName(), person.getSurname(), person.getWorkplace())
        );
    }
}
