package school.faang.harryPotter;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Student {
    private final String name;
    private final int year;
    private int points = 0;
}
