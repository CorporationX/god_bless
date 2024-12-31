package school.faang.bjs250985;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;
}