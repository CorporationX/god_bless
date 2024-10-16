package school.faang.task318.person;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        for (Person p : persons) {
            System.out.println(String.format("%s %s %d %s", p.getName(), p.getSurname(), p.getAge(), p.getWorkplace()));
        }
    }
}
