package faang.school.godbless.sprint4.triwizardTournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year = 1965;
    @Setter
    private int points;
}
