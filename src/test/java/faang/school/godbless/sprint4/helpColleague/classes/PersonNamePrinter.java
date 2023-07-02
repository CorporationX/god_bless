package faang.school.godbless.sprint4.helpColleague.classes;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private final List<Integer> persons;

    @Override
    public void run() {
        persons.forEach(System.out::println);
    }

    public PersonNamePrinter(List<Integer> persons) {
        this.persons = persons;
    }
}