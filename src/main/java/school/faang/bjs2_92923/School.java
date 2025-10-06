package school.faang.bjs2_92923;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public synchronized int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
