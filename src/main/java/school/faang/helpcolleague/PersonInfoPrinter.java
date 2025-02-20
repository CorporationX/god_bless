package school.faang.helpcolleague;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    public PersonInfoPrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        for (Person person : persons) {
            log.info("Информация по пользователю: {},{},{},{}",
                    person.name(), person.surname(), person.age(), person.workplace());
        }
    }
}
