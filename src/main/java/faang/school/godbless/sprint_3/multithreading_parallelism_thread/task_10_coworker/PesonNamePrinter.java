package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

import java.util.List;

public record PesonNamePrinter(List<Person> personList) implements Runnable{
    @Override
    public void run() {
        personList.forEach(p -> System.out.println(p.name()));
    }
}
