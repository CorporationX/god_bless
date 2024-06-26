package faang.school.godbless.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    @Setter
    private int points;
}
