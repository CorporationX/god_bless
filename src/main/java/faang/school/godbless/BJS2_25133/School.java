package faang.school.godbless.BJS2_25133;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
