package faang.school.godbless.helpCollegue;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class PersonNamePrinter implements Runnable {
    @NonNull
    private List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
