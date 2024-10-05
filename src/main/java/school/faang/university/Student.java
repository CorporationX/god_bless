package school.faang.university;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    @Override
    public String toString() {
        return "Student: {" + name + ", " + faculty + ", " + year + "}";
    }
}
