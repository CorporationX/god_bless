package school.faang.task_50870;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}