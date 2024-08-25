package faang.school.godbless.helpColleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private final List<Person> people;
    private final int startIndex;
    private final int endIndex;

    public PersonNamePrinter(List<Person> people, int startIndex, int endIndex) {
        this.people = people;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(people.get(i).getName());
        }
    }
}
