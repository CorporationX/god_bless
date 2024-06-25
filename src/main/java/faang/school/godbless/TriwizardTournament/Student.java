package faang.school.godbless.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private String name;
    private int year;
    @Setter
    private int points;
}
