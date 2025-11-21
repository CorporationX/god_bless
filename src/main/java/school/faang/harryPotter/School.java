package school.faang.harryPotter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
