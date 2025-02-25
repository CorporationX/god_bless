package school.faang.sprint4.task_62777;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class School {
    @Getter
    private final String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .map(AtomicInteger::get)
                .reduce(0, Integer::sum);
    }

    public synchronized School completeTask(Task task) {
        team.stream()
                .filter(Objects::nonNull)
                .findFirst()
                .get().completeTask(task);
        return this;
    }
}
