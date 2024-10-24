package school.faang.BJS2_38970_TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public void updateStudentsPoints(int points) {
        students.forEach(student -> student.updatePoints(points / students.size()));
    }

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
