package school.faang.sprint_3.task_43548;

import java.util.List;

public record PersonInfoPrinter(List<Person> people) implements Runnable {
    @Override
    public void run() {
        people.forEach(System.out::println);
    }
}
