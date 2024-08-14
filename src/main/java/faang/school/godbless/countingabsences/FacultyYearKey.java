package faang.school.godbless.countingabsences;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class FacultyYearKey {
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return faculty + " (Year " + year + ")";
    }
}