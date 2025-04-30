package school.faang.stream4.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private long points;
}
