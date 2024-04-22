package faang.school.godbless.bjs2_5908;

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

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
