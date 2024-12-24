package school.faang.task_50880;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }
}
