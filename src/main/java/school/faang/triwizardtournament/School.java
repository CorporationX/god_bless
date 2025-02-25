package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    @NonNull
    private final String name;
    @NonNull
    private final List<Student> students;

    public int getTotalPoints() {
        return students
                .stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
