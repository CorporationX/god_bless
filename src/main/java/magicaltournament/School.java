package magicaltournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private final String name;
    private List<Student> team;

    int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
