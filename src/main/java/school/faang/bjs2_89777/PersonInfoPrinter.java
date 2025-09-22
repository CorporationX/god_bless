package school.faang.bjs2_89777;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            log.debug("Имя: {}.", person.getName());
            log.debug("Фамилия: {}.", person.getSurname());
            log.debug("Возраст: {}.", person.getAge());
            log.debug("Место работы: {}.", person.getWorkplace());
        }
    }
}
