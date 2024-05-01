package faang.school.godbless.async.task_5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(0);
    }
}