package faang.school.godbless.tournament_of_three;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    @Setter
    private int points;
}
