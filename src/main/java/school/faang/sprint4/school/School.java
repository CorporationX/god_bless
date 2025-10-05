package school.faang.sprint4.school;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
public class School {

    private final String name;
    private final List<Student> team;

    // правильно ли, при условии, что метод может быть вызван в любом месте турнира?
    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(new AtomicInteger(0), (result, point) -> new AtomicInteger(result.addAndGet(point.get())))
                .get();
    }

    public void doTask(Task task) {
        try {
            System.out.printf("%s start task %s\n", Thread.currentThread().getName(), name);
            Thread.sleep(TimeUnit.SECONDS.toMillis(task.getDifficulty()));
            team.forEach(student -> student.addPoints(task.getReward()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
