package faang.school.godbless.fourth.Tournament;

import lombok.Data;

@Data
public class Student {
    private final String name;
    private final int year;
    private int points = 0;
}
