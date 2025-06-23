package school.faang.triwizard_tournament;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
