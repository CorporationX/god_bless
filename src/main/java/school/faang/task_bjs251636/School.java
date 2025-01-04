package school.faang.task_bjs251636;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }

}
