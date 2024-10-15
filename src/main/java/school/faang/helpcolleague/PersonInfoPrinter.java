package school.faang.helpcolleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable{
    private List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
