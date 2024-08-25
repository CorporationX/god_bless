package faang.school.godbless.help_on_work;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class PersonNamePrinter implements Runnable {
    protected final List<Person> workersList;

    public PersonNamePrinter(List<Person> personList) {
        this.workersList = personList;
    }

    @Override
    public void run() {
        for (Person person : workersList) {
            System.out.println(person.getName());
        }
    }

    public void addPerson(Person person) {
        workersList.add(person);
    }
}
