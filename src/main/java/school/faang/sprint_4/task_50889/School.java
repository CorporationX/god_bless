package school.faang.sprint_4.task_50889;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        if (team == null) {
            throw new IllegalStateException("team is null");
        }
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
