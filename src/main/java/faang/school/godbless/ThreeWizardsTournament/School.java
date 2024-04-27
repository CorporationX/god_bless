package faang.school.godbless.ThreeWizardsTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void addPoints(int points) {
        team.forEach(student -> student.setPoints(student.getPoints() + points));
    }
}
