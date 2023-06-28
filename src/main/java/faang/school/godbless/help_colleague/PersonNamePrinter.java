package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> list;

    @Override
    public void run() {
        list.stream().map(Person::getName).forEach(System.out::println);
    }
}
