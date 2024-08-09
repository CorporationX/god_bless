package faang.school.godbless.countingtruancy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return name + " (" + faculty + ", year " + year + ")";
    }
}
