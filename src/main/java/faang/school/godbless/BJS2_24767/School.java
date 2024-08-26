package faang.school.godbless.BJS2_24767;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(student -> student.getPoints())
                .sum();
    }
}
