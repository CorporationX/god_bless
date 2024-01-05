package faang.school.godbless.BJS2_1340;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public int getTotalPoints () {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}