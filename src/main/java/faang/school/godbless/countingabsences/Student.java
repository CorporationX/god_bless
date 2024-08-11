package faang.school.godbless.countingabsences;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return name + " (Year " + year + ", Faculty: " + faculty + ")";
    }
}