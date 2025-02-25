package school.faang.tournament_wizzards;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
