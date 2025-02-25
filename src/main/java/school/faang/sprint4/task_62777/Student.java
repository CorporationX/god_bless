package school.faang.sprint4.task_62777;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
@Getter
@ToString
public class Student {
    private final String name;
    private final AtomicInteger points = new AtomicInteger();
    private int year;

    public synchronized void completeTask(Task task) {
        log.debug("Ученик {} преступил к задаче {}", this, task.name());
        points.addAndGet(task.start());
        log.debug("Ученик {} выполнил задачу {}", this, task.name());
    }
}
