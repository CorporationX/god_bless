package faang.school.godbless.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public long getTotalPoints() {
        return students.stream().mapToLong(Student::getPoints).sum();
    }
}
