package school.faang.stream4.triwizardtournament;

import lombok.Data;
import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public long getTotalPoints() {
        return team
                .stream()
                .mapToLong(Student::getPoints)
                .sum();
    }
}
