package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonNamePrinter implements Runnable{

    private List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getSureName());
        }
    }
}
