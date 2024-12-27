package school.faang.bjs_50846;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int educationYear;
    @Setter
    private int points;
}
