package faang.school.godbless.help;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> personList;

    @Override
    public void run() {
        personList.forEach(System.out::println);
    }
}
