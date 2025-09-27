package school.faang.bjs2_92915;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {

    private final String name;
    List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
