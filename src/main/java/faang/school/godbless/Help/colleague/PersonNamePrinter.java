package faang.school.godbless.Help.colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> personList;

    @Override
    public void run() {
        personList.stream().forEach(p -> System.out.println(p.getName() + " " + p.getSurname()));
    }
}
