package faang.school.godbless.help_employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.getWorkplace());
        }
    }
}

