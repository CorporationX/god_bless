package faang.school.godbless.task.multithreading.help.collegue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PersonNamePrinter implements Runnable{
    private final List<Person> people;

    @Override
    public void run() {
        people
                .forEach(person -> log.info("{}",person.getName()));
    }
}
