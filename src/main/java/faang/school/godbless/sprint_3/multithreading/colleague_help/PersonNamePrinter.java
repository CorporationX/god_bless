package faang.school.godbless.sprint_3.multithreading.colleague_help;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> personList;

    @Override
    public void run() {
        personList.forEach(System.out::println);
    }
}
