package school.faang.tournament_wizzards;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private final String name;
    private final int year;
    private int points;
}
