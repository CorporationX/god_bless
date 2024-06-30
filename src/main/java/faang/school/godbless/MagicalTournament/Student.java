package faang.school.godbless.MagicalTournament;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
    @NonNull
    private String name;
    @NonNull
    private int year;
    private int points;
}
