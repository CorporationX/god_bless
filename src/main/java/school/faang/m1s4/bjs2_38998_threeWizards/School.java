package school.faang.m1s4.bjs2_38998_threeWizards;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return (team.stream()
                .mapToInt(Student::getPoints)
                .sum());
    }
}
