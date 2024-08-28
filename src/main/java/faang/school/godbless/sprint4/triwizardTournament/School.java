package faang.school.godbless.sprint4.triwizardTournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> students;
    private int total;

    public int getTotalPoints() {
        total = students.stream()
                .mapToInt(Student::getPoints)
                .sum();
        return total;
    }
}
