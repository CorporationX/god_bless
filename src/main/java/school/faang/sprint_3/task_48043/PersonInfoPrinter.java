package school.faang.sprint_3.task_48043;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    @NonNull
    private final List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
