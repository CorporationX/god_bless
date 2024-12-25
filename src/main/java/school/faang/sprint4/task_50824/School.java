package school.faang.sprint4.task_50824;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class School {
    private final String name;
    private final List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .mapToInt((student) -> student.getPoints().get())
                .sum();
    }
}
