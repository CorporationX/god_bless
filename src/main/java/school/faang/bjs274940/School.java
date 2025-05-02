package school.faang.bjs274940;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class School {
    private static final int DEFAULT_POINTS = 0;

    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        if (team.isEmpty()) {
            return DEFAULT_POINTS;
        }

        return team.stream()
                .map(Student::getPoints)
                .reduce(DEFAULT_POINTS, Integer::sum);
    }
}
