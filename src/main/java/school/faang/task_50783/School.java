package school.faang.task_50783;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public double getTotalPoints() {
        return team.stream()
                .mapToDouble(student -> student.getPoints())
                .sum();
    }
}
