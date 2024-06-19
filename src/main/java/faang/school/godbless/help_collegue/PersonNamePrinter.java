package faang.school.godbless.help_collegue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> personList;

    @Override
    public void run() {
        printAllPeopleName();
    }

    private void printAllPeopleName() {
        personList.forEach(person -> System.out.println(person.name()));
    }
}
