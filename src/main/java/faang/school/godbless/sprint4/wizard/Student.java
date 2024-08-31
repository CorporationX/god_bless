package faang.school.godbless.sprint4.wizard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points = 0;
}
