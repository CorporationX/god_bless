package faang.school.godbless.tuancy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode


public class Student {
    private final String name;
    private final String faculty;
    private final int year;



}
