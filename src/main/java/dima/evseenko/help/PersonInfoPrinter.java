package dima.evseenko.help;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        persons.forEach(System.out::println);
    }
}
