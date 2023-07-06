package faang.school.godbless.parallelismAndThread.helpColleague;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> people;
    @Override
    public void run() {
        people.forEach(person -> System.out.println(person.getName()));
    }
}
