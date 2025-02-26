package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .flatMapToInt(student -> IntStream.of(student.getPoint()))
                .sum();
    }
}
