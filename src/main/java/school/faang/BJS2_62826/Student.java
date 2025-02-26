package school.faang.BJS2_62826;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter

public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points;
}
