package school.faang.three_mages_tournament_BJS2_38921;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(0);
    }
}