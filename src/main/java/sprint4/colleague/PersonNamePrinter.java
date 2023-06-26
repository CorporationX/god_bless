package sprint4.colleague;

import lombok.Data;

import java.util.List;

@Data
public class PersonNamePrinter implements Runnable {
    private List<Person> people;

    public PersonNamePrinter(List<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        for (Person person : people) {
            System.out.printf("%s\n", person.name());
        }
    }
}
