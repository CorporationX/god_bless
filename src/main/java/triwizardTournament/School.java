package triwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private final List<Student> team = new ArrayList<>();

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

    public void addStudentToTeam(Student student) {
        if (student == null) {
            throw new NullPointerException("Student must be exist");
        }
        team.add(student);
    }
}
