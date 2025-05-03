package school.faang.multithreading.async.bjs2_74925.triwizard_tournamrnt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
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
