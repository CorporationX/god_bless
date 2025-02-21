package colleaguehelp;

import java.util.List;
import java.util.logging.Logger;

public class PersonInfoPrinter implements Runnable {
    private static final Logger logger = Logger.getLogger(PersonInfoPrinter.class.getName());
    private final List<Person> persons;

    public PersonInfoPrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (var person : persons) {
            logger.info(String.format("%s - Person: {%s, %s, Age: %d, %s}",
                    threadName, person.name(), person.surname(), person.age(), person.workplace()));
        }
    }
}