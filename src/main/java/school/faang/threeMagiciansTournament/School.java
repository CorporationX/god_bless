package school.faang.threeMagiciansTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public boolean compareResults(School school) {
        return this.getTotalPoints() > school.getTotalPoints();
    }
}
