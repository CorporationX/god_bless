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
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
