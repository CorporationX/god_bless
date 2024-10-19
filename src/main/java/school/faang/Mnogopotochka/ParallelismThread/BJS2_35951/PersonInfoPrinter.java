package school.faang.Mnogopotochka.ParallelismThread.BJS2_35951;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(PersonInfoPrinter.class);
    private List<Person> personList;

    public PersonInfoPrinter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void run() {
        if (personList == null || personList.isEmpty()) {
            logger.warn("Person list is empty or null");
            return;
        }
        personList.forEach(person -> System.out.println(
                        "ID: " + person.getId() +
                        " Name: " + person.getName() +
                        ", Surname: " + person.getSurname() +
                        ", Age: " + person.getAge() +
                        ", Workplace: " + person.getWorkplace()
        ));
    }
}
