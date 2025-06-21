package school.faang.bjs2_81290;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PersonInfoPrinter implements Runnable {
    private final List<Person> batch;

    public PersonInfoPrinter(List<Person> batch) {
        this.batch = batch;
    }

    @Override
    public void run() {
        for (Person person : batch) {
            log.info("Person info: {}, {}, {}", person.getName(), person.getSurname(), person.getWorkplace());
        }
    }
}
