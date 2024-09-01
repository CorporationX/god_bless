package three_wizards_tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

}
