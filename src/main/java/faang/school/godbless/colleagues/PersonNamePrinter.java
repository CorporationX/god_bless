package faang.school.godbless.colleagues;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.getWorkplace());
        }
    }
}
