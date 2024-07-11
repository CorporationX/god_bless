package faang.school.godbless.async.triwizard_tournament;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Student {
    private String name;
    private int year;
    private int points;
}
