package faang.school.godbless.colleagueHelp;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonNamePrinter implements Runnable {

    private final List<Person> people;

    @Override
    public void run() {
        people.forEach(p -> System.out.println(p.name()));
    }
}
