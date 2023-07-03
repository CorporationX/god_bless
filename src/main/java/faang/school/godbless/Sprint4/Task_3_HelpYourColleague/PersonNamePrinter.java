package faang.school.godbless.Sprint4.Task_3_HelpYourColleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> people;

    public PersonNamePrinter (List<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}
