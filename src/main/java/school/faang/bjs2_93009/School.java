package school.faang.bjs2_93009;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class School {
    private final Object lock = new Object();
    private String name;
    private List<Student> team;

    int getTotalPoints() {
        return team.stream()
                .map(student -> student.getPoints())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
