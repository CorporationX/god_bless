package school.faang.task_50901;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
