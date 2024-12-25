package school.faang.task_50744;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.util.List;

@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public School(String name, List<Student> team) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("schoolName");
        }
        if (team == null) {
            throw new CheckException("team");
        }

        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(student -> student.getPoints().get()).sum();
    }
}
