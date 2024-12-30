package school.faang.magic_tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class School {
    private final String name;
    private final List<Student> team = new ArrayList<>();

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
