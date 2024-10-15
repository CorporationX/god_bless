package school.BJS2_35964;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {

    private List<Person> persons;

    @Override
    public void run() {
        persons.stream().forEach(person ->
        {
            System.out.printf("Имя человека: %s, фамилия: %s, место работы: %s", person.getName(), person.getSurname(), person.getWorkplace());
            System.out.println();
        });
    }
}
