package Sprint_4_Task3;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    public PersonNamePrinter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {

    }
}
