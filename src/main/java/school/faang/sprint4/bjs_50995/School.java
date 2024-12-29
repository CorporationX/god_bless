package school.faang.sprint4.bjs_50995;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;
    @Setter
    private int totalPoints = 0;
}
