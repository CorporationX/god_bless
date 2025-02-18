package school.faang.helpacolleague;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            log.info("Имя: {}, Фамилия: {}, Место работы: {}.",
                    person.getName(), person.getSurname(), person.getWorkplace());
        }
    }
}
