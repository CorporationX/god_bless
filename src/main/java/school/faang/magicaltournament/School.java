package school.faang.magicaltournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        int sum = team.stream().mapToInt(Student::getPoints).sum();
        return sum;
    }
}

