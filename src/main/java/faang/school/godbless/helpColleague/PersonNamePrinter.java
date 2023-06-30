package faang.school.godbless.helpColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> people;

    @Override
    public void run() {
        people.forEach((person) ->
                System.out.println(person.getWorkplace())
        );
    }
}
