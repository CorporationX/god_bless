package faang.school.godbless.BJS2_24785;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    @Getter
    @Setter
    private int points;

}
