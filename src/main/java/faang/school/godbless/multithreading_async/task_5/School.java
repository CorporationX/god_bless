package faang.school.godbless.multithreading_async.task_5;

import java.util.List;

public record School(String name, List<Student> team) {
    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
