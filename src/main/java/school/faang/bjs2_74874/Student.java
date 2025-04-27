package school.faang.bjs2_74874;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points;
}