package school.faang.magictournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoint() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
