package school.faang.help_the_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> listToPrint;

    @Override
    public void run() {
        for (Person person : listToPrint) {
            System.out.println(person.getName()+ " " + person.getSurname() + " " + person.getWorkplace());
        }
    }
}
