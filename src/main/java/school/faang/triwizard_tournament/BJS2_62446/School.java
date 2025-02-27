package school.faang.triwizard_tournament.BJS2_62446;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }
}
