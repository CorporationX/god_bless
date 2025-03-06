package school.faang.BJS2_62486;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints)
                .sum();
    }
}
