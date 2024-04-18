package faang.school.godbless.bjs2_5562;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> personList;

    @Override
    public void run() {
        personList.forEach(person -> System.out.println(person.getName() + " : " + person.getWorkplace()));
    }
}
