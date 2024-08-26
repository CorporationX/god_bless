package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public long getTotalPoints() {
        return team
                .stream()
                .mapToLong(Student::getPoint)
                .sum();
    }
}
