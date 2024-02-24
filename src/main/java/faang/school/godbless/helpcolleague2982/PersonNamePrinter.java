package faang.school.godbless.helpcolleague2982;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> personList;

    @Override
    public void run() {
        this.personList.forEach(System.out::println);
    }
}
