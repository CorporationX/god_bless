package faang.school.godbless.sprint_3.multithreading.colleague_help;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    Person person;

    @Override
    public void run() {
        System.out.println(person.getName());
    }
}
