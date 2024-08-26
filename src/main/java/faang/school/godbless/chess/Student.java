package faang.school.godbless.chess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;
}
