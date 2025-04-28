package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    List<Student> team;

    public int getTotalPoints(List<Student> students) {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
