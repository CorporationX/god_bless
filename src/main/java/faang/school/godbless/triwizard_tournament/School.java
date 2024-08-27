package faang.school.godbless.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {

    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .reduce(0,
                        (subtotal, nextValue) -> subtotal + nextValue.getPoints(),
                        Integer::sum);
    }
}
