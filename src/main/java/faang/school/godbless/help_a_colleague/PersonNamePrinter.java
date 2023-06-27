package faang.school.godbless.help_a_colleague;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private List<Person> persons;
    @Override
    public void run() {
        List<String> names = persons.stream().map(Person::getName).toList();
        for(String name : names) {
            System.out.println(name);
        }
    }
}
