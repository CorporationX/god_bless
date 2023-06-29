package faang.school.godbless.helpColleague;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person.getWorkplace());
        }
    }
}
