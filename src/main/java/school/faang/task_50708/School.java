package school.faang.task_50708;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .reduce(0, (sum, student) -> sum + student.getPoints(), Integer::sum);
    }
}
