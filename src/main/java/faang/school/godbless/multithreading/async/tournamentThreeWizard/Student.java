package faang.school.godbless.multithreading.async.tournamentThreeWizard;

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
