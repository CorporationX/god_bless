package faang.school.godbless.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }
}
