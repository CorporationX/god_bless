package bjs262388;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints(List<Student> team) {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
