package school.faang.bjs2_82727;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@EqualsAndHashCode(of = {"name"})
@RequiredArgsConstructor
public class School {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public Student getStudentForTask() {
        return team.get(RANDOM.nextInt(team.size()));
    }
}
