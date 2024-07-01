package faang.school.godbless.theTriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team = new ArrayList<Student>();

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
