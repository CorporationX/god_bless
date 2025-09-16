package school.faang.bjs2_89657;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Getter
public class PersonInfoPrinter implements Runnable {
    private List<Person> listPerson;

    @Override
    public void run() {
        listPerson.forEach(person -> log.info("{}", person));
    }
}
