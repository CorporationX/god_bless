package school.faang.truancy;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {

    private final String name;
    private final String faculty;
    private final int year;
}
