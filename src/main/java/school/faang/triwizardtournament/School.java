package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
