package school.faang.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {

    private final String name;
    private final List<Student> team;

    private int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
