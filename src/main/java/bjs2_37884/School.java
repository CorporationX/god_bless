package bjs2_37884;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, (sum, curr) -> sum += curr);
    }
}
