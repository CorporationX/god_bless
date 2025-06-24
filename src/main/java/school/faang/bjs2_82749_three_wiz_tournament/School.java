package school.faang.bjs2_82749_three_wiz_tournament;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class School {
    private final String name;
    @NonNull
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(s -> s.getPoints().get())
                .sum();
    }
}
