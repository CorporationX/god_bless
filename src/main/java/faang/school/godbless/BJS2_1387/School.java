package faang.school.godbless.BJS2_1387;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();
    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
