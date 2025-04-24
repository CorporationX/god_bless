package src.faang.service;

import lombok.RequiredArgsConstructor;
import src.faang.model.Person;

import java.util.List;

@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
