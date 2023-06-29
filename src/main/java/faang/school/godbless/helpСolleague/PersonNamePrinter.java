package faang.school.godbless.helpСolleague;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    Person person;

    @Override
    public void run() {
        System.out.println(person.getName());
    }
}
