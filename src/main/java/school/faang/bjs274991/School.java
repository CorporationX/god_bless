package school.faang.bjs274991;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;
    @Setter
    private long finishTime;

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student s : team) {
            totalPoints += s.getPoints();
        }
        return totalPoints;
    }
}
