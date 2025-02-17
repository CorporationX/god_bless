package school.faang;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private final List<Person> personList;

    public PersonInfoPrinter(List<Person> personList) {
        validateList(personList);
        this.personList = personList;
    }

    @Override
    public void run() {
        System.out.println(personList);
    }

    private void validateList(List<Person> personList) {
        if (personList == null) {
            throw new IllegalArgumentException("List of persons can't be null.");
        }
    }
}
