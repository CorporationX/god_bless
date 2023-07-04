package faang.school.godbless.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public Integer getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(Integer reward){
        team.forEach(student -> student.setPoints(student.getPoints() + reward));
    }
}
