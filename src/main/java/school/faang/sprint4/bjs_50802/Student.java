package school.faang.sprint4.bjs_50802;

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
