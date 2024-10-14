package school.faang.helpingacolleague;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PersonInfoPrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        people.forEach(p -> System.out.printf("\nname: %s, surname : %s, age : " +
                        "%d, " +
                        "workplace : %s",
                p.getName(), p.getSurname(), p.getAge(),
                p.getWorkplace()));
    }
}
