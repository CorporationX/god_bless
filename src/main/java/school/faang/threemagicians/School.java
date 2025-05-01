package school.faang.threemagicians;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class School {
    private static final int DEFAULT_POINTER = 0;

    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(DEFAULT_POINTER);

    }

}