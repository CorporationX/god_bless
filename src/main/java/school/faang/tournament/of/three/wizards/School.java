package school.faang.tournament.of.three.wizards;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;
    private final Object lock = new Object();

    public void awardPointsToTeam(int points) {
        synchronized (lock) {
            team.forEach(student -> student.addPoints(points));
        }
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
