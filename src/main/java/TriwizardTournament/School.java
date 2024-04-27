package TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(s -> s.getPoints())
                .sum();
    }
}
