package school.faang.bjs2_92813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    @Getter
    @Setter
    private int points;
}
