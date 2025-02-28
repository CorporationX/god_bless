package school.faang.BJS2_60578;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.printf("%s %s %d %s\n", person.getName(),
                    person.getSurname(), person.getAge(), person.getWorkplace());
        }
    }
}
